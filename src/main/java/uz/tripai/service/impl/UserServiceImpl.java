package uz.tripai.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.entity.User;
import uz.tripai.repository.UserRepository;
import uz.tripai.security.service.oauth2.EProvider;
import uz.tripai.security.service.oauth2.user.OAuth2UserInfo;
import uz.tripai.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    @Override
    public User getUserByProviderId(String providerId) {
        return repository.findByProviderId(providerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User was not found by provider id: %s", providerId)));
    }

    @Override
    public User createOrUpdate(EProvider provider, OAuth2UserInfo userInfo) {
        return null;
    }
}
