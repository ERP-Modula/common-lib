package com.modula.common.core;

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.modula.common.connections.dto.connection.impl.OAuth2ExternalConnectionDto;
import lombok.RequiredArgsConstructor;
import modula.platform.google.client.CoreBuilderConnectionClient;
import modula.platform.google.configuration.GoogleProperties;
import modula.platform.google.domain.entity.token.GoogleToken;
import modula.platform.google.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConnectionTokenService {

    private final GoogleProperties googleProperties;
    private final TokenRepository tokenRepository;
    private final CoreBuilderConnectionClient coreBuilderConnectionClient;

    public void handleAuthCode(String code) throws IOException {
        GoogleTokenResponse tokenResponse = new ё(
                new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                googleProperties.getClientId(),
                googleProperties.getClientSecret(),
                code,
                googleProperties.getRedirectUri()
        ).execute();

        saveTokens(tokenResponse);

        System.out.println(tokenResponse.toPrettyString());
    }

    private void saveTokens(GoogleTokenResponse tokenResponse) throws IOException {

        GoogleToken googleToken;
        String userEmail = tokenResponse.parseIdToken().getPayload().getEmail();

        Optional<GoogleToken> optionalGoogleToken = tokenRepository.findByUserEmail(userEmail);
        googleToken = optionalGoogleToken.orElseGet(GoogleToken::new);

        googleToken.setAccessToken(tokenResponse.getAccessToken());
        googleToken.setRefreshToken(tokenResponse.getRefreshToken());
        googleToken.setIdToken(tokenResponse.getIdToken());
        googleToken.setScopes(tokenResponse.getScope());
        googleToken.setUserEmail(userEmail);

        tokenRepository.saveAndFlush(googleToken);
    }

    public String getTokenByUserEmail(UUID connectionId) {
        OAuth2ExternalConnectionDto externalConnectionDto = (OAuth2ExternalConnectionDto) coreBuilderConnectionClient.getConnection(connectionId);
        return externalConnectionDto.getAccessToken();
    }
}
