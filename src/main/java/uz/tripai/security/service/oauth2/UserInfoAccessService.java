package uz.tripai.security.service.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import uz.tripai.security.service.oauth2.user.OAuth2UserInfo;
import uz.tripai.security.service.oauth2.user.OAuth2UserInfoFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class UserInfoAccessService {

    private static String clientId;
    private static String apiSecret;
    private static String userInfoUri;

    public UserInfoAccessService(@Value("${google.client-id}") String clientId,
                                 @Value("${google.api-secret}") String apiSecret,
                                 @Value("${google.user-info-uri}") String userInfoUri) {
        UserInfoAccessService.clientId = clientId;
        UserInfoAccessService.apiSecret = apiSecret;
        UserInfoAccessService.userInfoUri = userInfoUri;
    }

    public static OAuth2UserInfo getUserInfo(EProvider provider, String code) {
        if (!provider.equals(EProvider.GOOGLE)){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, String.format("Sorry! Login with %s is not supported yet.", provider));
        }
        OAuth20Service oAuth20Service = OAuth2ServiceFactory.getOAuth2Service(provider, clientId, apiSecret);
        OAuth2AccessToken accessToken;
        try {
            accessToken = oAuth20Service.getAccessToken(code);
        } catch (IOException | ExecutionException | InterruptedException | OAuth2AccessTokenErrorResponse e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
        if (accessToken == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access token is null");
        }
        OAuthRequest request = new OAuthRequest(Verb.GET, userInfoUri);
        oAuth20Service.signRequest(accessToken, request);
        try (Response response = oAuth20Service.execute(request)){
            Map<String, Object> map = new ObjectMapper().readValue(response.getBody(), HashMap.class);
            return OAuth2UserInfoFactory.getOAuth2UserInfo(provider, map);
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }

    }

}
