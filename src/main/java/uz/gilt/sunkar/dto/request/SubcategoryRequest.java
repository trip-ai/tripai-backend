package uz.gilt.sunkar.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import uz.gilt.sunkar.dto.CategoryDto;

import java.sql.Timestamp;

public record SubcategoryRequest(
        String name,
        boolean status,
        long categoryId
) {
}
