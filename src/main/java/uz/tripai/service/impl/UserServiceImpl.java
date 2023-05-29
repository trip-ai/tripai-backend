package uz.tripai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.dto.request.UserRequest;
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
        user.setImageUrl(userInfo.getImageUrl());
        return repository.save(user);
    }

    @Override
    public User getOrCreate(UserRequest request) {
        User user = repository.findByProviderId(request.providerId()).orElse(new User());
        user.setName(user.getName());
        user.setProviderId(request.providerId());
        user.setEmail(request.email());
        user.setImageUrl(request.imageUrl());
        if (user.getId() == null) {
            user.setRoles(Set.of(roleService.getRole(ERole.ROLE_USER)));
            user.setProvider(request.provider());
        }
        return repository.save(user);
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Resource not found (id: %d)", id)));
    }
}
