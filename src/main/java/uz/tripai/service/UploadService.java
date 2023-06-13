package uz.tripai.service;

import org.springframework.web.multipart.MultipartFile;
import uz.tripai.dto.response.UploadResponse;

public interface UploadService {
    UploadResponse storeImage(MultipartFile file);
}
