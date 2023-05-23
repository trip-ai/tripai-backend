package uz.tripai.dto.request;

import uz.tripai.security.oauth2.EProvider;

public record UserRequest(
        String name,
        String email,
        String providerId,
        String imageUrl,
        EProvider provider
){};
