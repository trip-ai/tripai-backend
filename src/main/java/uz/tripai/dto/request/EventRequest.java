package uz.tripai.dto.request;

public record EventRequest(
        String title,
        String description,
        String content,
        boolean status
) {
}
