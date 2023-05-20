package uz.tripai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.entity.User;
import uz.tripai.entity.enumerate.ERole;
import uz.tripai.repository.UserRepository;
import uz.tripai.security.oauth2.EProvider;
import uz.tripai.security.oauth2.user.OAuth2UserInfo;
import uz.tripai.service.RoleService;
import uz.tripai.service.UserService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleService roleService;
    @Override
    public User getUserByProviderId(String providerId) {
        return repository.findByProviderId(providerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User was not found by provider id: %s", providerId)));
    }

    @Override
    public User createOrUpdate(EProvider provider, OAuth2UserInfo userInfo) {
        User user = repository.findByProviderId(userInfo.getId()).orElse(User.builder()
                        .provider(provider)
                        .providerId(userInfo.getId())
                        .roles(Set.of(roleService.getRole(ERole.ROLE_USER)))
                .build());
        user.setEmail(userInfo.getEmail());
        user.setName(userInfo.getName());
        return repository.save(user);
    }
}
