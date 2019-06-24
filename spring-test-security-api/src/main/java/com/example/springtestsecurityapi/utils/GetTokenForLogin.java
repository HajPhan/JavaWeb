package com.example.springtestsecurityapi.utils;

import com.example.springtestsecurityapi.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetTokenForLogin {

    private final static String URL_API_LOGIN = "http://localhost:8081/api/login/";

    public static String getToken(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<String> token = null;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity entity = new HttpEntity(user, headers);

        RestTemplate restTemplate = new RestTemplate();

        token = restTemplate.exchange(URL_API_LOGIN, HttpMethod.POST, entity, String.class);

        return token.getBody();
    }
}
