package uz.tripai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.tripai.dto.response.UploadResponse;
import uz.tripai.service.UploadService;

@RestController
@RequestMapping("api/upload")
@RequiredArgsConstructor
public class UploadController {
    private final UploadService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UploadResponse> upload(@ModelAttribute MultipartFile file){
        return ResponseEntity.ok(service.storeImage(file));
    }
}
