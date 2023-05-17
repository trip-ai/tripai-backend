package uz.tripai.dto.response;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record ErrorResponse(
        String timestamp,
        int status,
        int code,
        String error,
        String message,
        String path
) {
    public ErrorResponse(HttpStatus httpStatus, String message, String path) {
        this(
                new Date().toString(),
                httpStatus.value(),
                0,
                httpStatus.getReasonPhrase(),
                message,
                path
        );
    }
}