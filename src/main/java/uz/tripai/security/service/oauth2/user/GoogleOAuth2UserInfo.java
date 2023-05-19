package uz.tripai.security.service.oauth2.user;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {
    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return String.valueOf(attributes.get("id"));
    }

    @Override
    public String getName() {
        if (attributes.containsKey("kakao_account")){
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            if(kakaoAccount.containsKey("profile")) {
                Map<String, Object>  profile = (Map<String, Object>) kakaoAccount.get("profile");
                if(profile.containsKey("nickname")) {
                    return (String) profile.get("nickname");
                }
            }
        }
        return null;
    }

    @Override
    public String getEmail() {
        if (attributes.containsKey("kakao_account")){
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            if(kakaoAccount.containsKey("email")) {
                return (String) kakaoAccount.get("email");
            }
        }
        return null;
    }

    @Override
    public String getImageUrl() {
        if (attributes.containsKey("kakao_account")){
            Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
            if(kakaoAccount.containsKey("profile")) {
                Map<String, Object>  profile = (Map<String, Object>) kakaoAccount.get("profile");
                if(profile.containsKey("profile_image_url")) {
                    return (String) profile.get("profile_image_url");
                }
            }
        }
        return null;
    }
}
