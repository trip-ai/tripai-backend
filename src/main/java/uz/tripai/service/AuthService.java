package uz.tripai.service;

import uz.tripai.dto.response.JwtResponse;
import uz.tripai.security.service.oauth2.EProvider;

public interface AuthService {
    JwtResponse authenticate(EProvider provider, String code);
}