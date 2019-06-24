package com.example.springjwttest.Test1;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Login {


    private final static String URL_API_LOGIN = "http://localhost:8081/api/login/";
    private final static String URL_API_USER = "http://localhost:8081/api/user/";

//    @RequestMapping(value = "/login?")
    public static String getToken (String username, String password){
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity<String> token = null;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        HttpEntity httpEntity = new HttpEntity(user,httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        token = restTemplate.exchange(URL_API_LOGIN, HttpMethod.POST,httpEntity,String.class);
        return token.getBody();
    }

    public static void callApiUser(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",token);

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate =new RestTemplate();
        ResponseEntity<Iterable> responseEntity = restTemplate.exchange(URL_API_USER,HttpMethod.GET,httpEntity,Iterable.class);
        List<LinkedHashMap<String,Object>> list = restTemplate.exchange(URL_API_USER,HttpMethod.GET,httpEntity,List.class).getBody();
    }

    public static void main(String [] args){
        String token = getToken("haipv","123");
        System.out.println("===============================================================================================");
        System.out.println("Token = " + token.toString());
        System.out.println("===============================================================================================");
        callApiUser(token);
    }



}
