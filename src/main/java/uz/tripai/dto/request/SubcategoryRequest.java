package uz.tripai.dto.request;

public record SubcategoryRequest(
        String name,
        boolean status,
        long categoryId
) {
}
