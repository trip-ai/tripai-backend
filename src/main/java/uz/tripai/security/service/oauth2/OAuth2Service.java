package uz.tripai.security.service.oauth2;

import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;

public class OAuth2Service {
    public static OAuth20Service google(String clientId, String apiSecret) {
        return new ServiceBuilder(clientId)
                .apiSecret(apiSecret)
                .build(GoogleApi20.instance());
    }

}
