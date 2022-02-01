package org.authserver.services;


import io.jsonwebtoken.lang.Assert;
import org.authserver.entities.AuthRequest;
import org.authserver.entities.AuthResponse;
import org.authserver.entities.dto.UserDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate,
                       final JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(AuthRequest authRequest) {
        authRequest.setPassword(BCrypt.hashpw(authRequest.getPassword(), BCrypt.gensalt()));

        UserDto userDto = restTemplate.postForObject("http://userservice/users", authRequest, UserDto.class);
        Assert.notNull(userDto, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userDto, "ACCESS");
        String refreshToken = jwt.generate(userDto, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }
}
