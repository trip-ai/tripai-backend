package uz.tripai.security.oauth2;

import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class OAuth2ServiceFactory {

    public static OAuth20Service getOAuth2Service(EProvider registrationId, String clientId, String apiSecret){
        if (registrationId.equals(EProvider.GOOGLE)){
            return OAuth2Service.google(clientId, apiSecret);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Sorry! Login with %s is not supported yet.", registrationId));
        }
    }
}
