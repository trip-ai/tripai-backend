package uz.tripai.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public record CategoryDto(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp updatedAt,
        String name,
        boolean status
) {
}
