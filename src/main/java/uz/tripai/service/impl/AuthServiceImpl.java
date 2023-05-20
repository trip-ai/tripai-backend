package uz.tripai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.tripai.dto.response.JwtResponse;
import uz.tripai.entity.User;
import uz.tripai.security.service.impl.UserDetailsImpl;
import uz.tripai.security.jwt.JwtUtils;
import uz.tripai.security.oauth2.EProvider;
import uz.tripai.security.oauth2.UserInfoAccessService;
import uz.tripai.security.oauth2.user.OAuth2UserInfo;
import uz.tripai.service.AuthService;
import uz.tripai.service.UserService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtils jwtUtils;
    private final UserService userService;
    @Override
    public JwtResponse authenticate(EProvider provider, String code) {
        OAuth2UserInfo userInfo = UserInfoAccessService.getUserInfo(provider, code);
        User user = userService.createOrUpdate(provider, userInfo);
        UserDetailsImpl userDetails = UserDetailsImpl.build(user);
        String jwt = jwtUtils.generateToken(userDetails);
        return new JwtResponse(jwt, user.getProviderId(), user.getRoles());
    }
}
