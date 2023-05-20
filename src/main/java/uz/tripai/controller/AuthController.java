package uz.tripai.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tripai.dto.response.JwtResponse;
import uz.tripai.security.oauth2.EProvider;
import uz.tripai.service.AuthService;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/oauth2/{provider}")
    public ResponseEntity<JwtResponse> authenticateUser(
            @Parameter(
                    name =  "provider",
                    schema = @Schema(
                            implementation = EProvider.class,
                            enumAsRef = true,
                            defaultValue = "GOOGLE",
                            allowableValues = {"GOOGLE"}),
                    required = true)
            @PathVariable("provider") EProvider provider, @RequestParam("code") String code) {
        return ResponseEntity.ok(authService.authenticate(provider, code));
    }
}
