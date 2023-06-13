package uz.tripai.service.impl;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.dto.response.UploadResponse;
import uz.tripai.service.UploadService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    private final Path path = Paths.get("uploads");
    private final String endpoint;
    private final Set<String> supportedTypes = Set.of("image/png", "image/jpg", "image/webp", "image/jpeg");
    public UploadServiceImpl(@Value("${server.endpoint}") String endpoint) {
        this.endpoint = endpoint;
        if (!Files.exists(path)){
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload(audio)!");
            }
        }
    }

    @Override
    public UploadResponse storeImage(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType != null && !supportedTypes.contains(contentType)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unsupported file type");
        }
        try {
            String imageName = String.format("%s.%s", UUID.randomUUID().toString().replaceAll("-",""),
                    FilenameUtils.getExtension(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), path.resolve(imageName));
            return new UploadResponse(String.format("%s/uploads/%s", endpoint, imageName), imageName);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
                    String.format("Could not store the file. Error: %s", e.getMessage()), e.getCause());
        }
    }
}
