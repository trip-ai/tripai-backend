package uz.tripai.security.oauth2.user;

import java.util.Map;

public class GoogleOAuth2UserInfo extends OAuth2UserInfo {
    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getId() {
        return String.valueOf(attributes.get("sub"));
    }

    @Override
    public String getName() {
        if (attributes.containsKey("name")){
            return String.valueOf(attributes.get("name"));
        }
        return null;
    }

    @Override
    public String getEmail() {
        if (attributes.containsKey("email")){
            return String.valueOf(attributes.get("email"));
        }
        return null;
    }

    @Override
    public String getImageUrl() {
        if (attributes.containsKey("picture")){
            return String.valueOf(attributes.get("picture"));
        }
        return null;
    }
}
