package uz.tripai.service;

import uz.tripai.dto.request.UserRequest;
import uz.tripai.entity.User;
import uz.tripai.security.oauth2.EProvider;
import uz.tripai.security.oauth2.user.OAuth2UserInfo;

public interface UserService {
    User getUserByProviderId(String providerId);
    User createOrUpdate(EProvider provider, OAuth2UserInfo userInfo);
    User getOrCreate(UserRequest request);
    User findById(long id);
}
