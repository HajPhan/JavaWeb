package com.example.springbootjwtjpasecurity.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private final static String URL_LOGIN = "http://localhost:8787/api/login/";
    private final static String URL_USER = "http://localhost:8787/api/user/";

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = {"/", "/login-page"})
    public String index() {
        return "login-page";
    }

    @RequestMapping(value = "/login-test")
    public String loginPage(@RequestParam("username") String username, @RequestParam("password") String password) {
        HttpHeaders headers = new HttpHeaders();

        // Request Body
        MultiValueMap<String, String> parameterMap = new LinkedMultiValueMap<String, String>();
        parameterMap.add("username", username);
        parameterMap.add("password", password);

        // Request Entity
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameterMap, headers);

        //RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //Post Login
        ResponseEntity<String> response = restTemplate.exchange(URL_LOGIN, HttpMethod.POST, requestEntity, String.class);

        HttpHeaders responseHeader = response.getHeaders();

        List<String> list = responseHeader.get("Authorization");
        return list == null || list.isEmpty() ? null : list.get(0);
    }

    public String callRESTApi(Model model, String restUrl, String authorizationString) {
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();

        // Authorization string (JWT)
        headers.set("Authorization", authorizationString);

        //
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));

        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);

        //HttpEntity<String>: To get result as String
        HttpEntity<String> entiy = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<String> respons = restTemplate.exchange(URL_USER, HttpMethod.GET, entiy, String.class);

//        String result = respons.getBody();

        model.addAttribute("userList",respons.getBody());
//        System.out.println(restUrl);
        return "user-page";
    }


//    public static void main(String [] args){
//        String username = "haipv";
//        String password = "123";
//
//        String authorizationString = loginPage(username,password);
//        System.out.println("Authorization String = " + authorizationString);
//
//        //Call REST API:
//        callRESTApi(URL_USER,authorizationString);
//    }
}
