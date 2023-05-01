package uz.gilt.sunkar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import uz.gilt.sunkar.entity.Category;

import java.sql.Timestamp;

public record SubcategoryDto(
        long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Almaty")
        Timestamp updatedAt,
        String name,
        boolean status,
        CategoryDto category
) {
}
