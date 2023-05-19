package uz.tripai.dto.response;

import uz.tripai.entity.Role;

import java.util.List;
import java.util.Set;

public record JwtResponse(String token, String providerId, List<Role> roles) {
    private static final String type = "Bearer";
}