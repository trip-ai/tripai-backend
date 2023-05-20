package uz.tripai.security.oauth2.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.security.oauth2.EProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(EProvider provider, Map<String, Object> attributes) {
        if (provider.equals(EProvider.GOOGLE)) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Sorry! Login with %s is not supported yet.", provider));
        }
    }
}
