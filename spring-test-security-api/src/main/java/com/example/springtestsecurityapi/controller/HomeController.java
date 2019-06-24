package com.example.springtestsecurityapi.controller;

import com.example.springtestsecurityapi.model.User;
import com.example.springtestsecurityapi.utils.GetTokenForLogin;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final static String URL_API_USER = "http://localhost:8081/api/user/";

    @RequestMapping(value = "/")
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login-page";
    }

    @RequestMapping(value = "/loginUser")
    public String doLogin(Principal principal, HttpServletRequest request) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        principal.getName().
//        HttpSession session = request.getSession();
        String token = null;

        if (username != null && password != null) {
            token = GetTokenForLogin.getToken(username, password);
            session.setAttribute("token", token);

            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("Token = " + token);
        }

        if (token != null) {
            return "redirect:/userInfo";
        }

        return "login-page";
    }

    @RequestMapping(value = "/userInfo")
    public String login(Model model, HttpSession session) {
        // Get Token from session
        String token = String.valueOf(session.getAttribute("token"));

//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMyIsImV4cCI6MTU1NTA2NDM2NSwidXNlcm5hbWUiOiJoYWlwdiJ9.KOLJj30YiAH3d19Y2g4fBKZKH91gdCNjviqxCqw-o84";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> mapUser = restTemplate.exchange(URL_API_USER, HttpMethod.GET, entity, List.class).getBody();

        List<User> list = new ArrayList<User>();
        for (LinkedHashMap<String, Object> map : mapUser) {
            User user = new User();
            user.setId(Integer.valueOf(String.valueOf(map.get("id"))));
            user.setFullname(String.valueOf(map.get("fullname")));
            user.setUsername(String.valueOf(map.get("username")));
            user.setPassword(String.valueOf(map.get("password")));

            list.add(user);
        }

        model.addAttribute("userList", list);
        return "user-info";
    }

    @RequestMapping(value = "/admin")
    public String adminPage(Model model, HttpSession session) {
        // Get Token from session
        String token = String.valueOf(session.getAttribute("token"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> mapUser = restTemplate.exchange(URL_API_USER, HttpMethod.GET, entity, List.class).getBody();

        List<User> list = new ArrayList<User>();
        for (LinkedHashMap<String, Object> map : mapUser) {
            User user = new User();
            user.setId(Integer.valueOf(String.valueOf(map.get("id"))));
            user.setFullname(String.valueOf(map.get("fullname")));
            user.setUsername(String.valueOf(map.get("username")));
            user.setPassword(String.valueOf(map.get("password")));

            list.add(user);
        }

        model.addAttribute("userList", list);
        return "admin-page";
    }

    @RequestMapping(value = "/user-view/{id}")
    public String viewUser(Model model, HttpSession session, @PathVariable int id){
        String token = String.valueOf(session.getAttribute("token"));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String, User> userObject = restTemplate.exchange(URL_API_USER + id, HttpMethod.GET, entity, LinkedHashMap.class).getBody();
        List<Object> list = new ArrayList<Object>();

        for (Map.Entry<String, User> map : userObject.entrySet()) {
            list.add(map.getValue());
        }
        model.addAttribute("user", list);
        return "user-view";
    }

    @RequestMapping(value = "/user-save")
    public String saveUser(Model model) {
        model.addAttribute("user", new User());
        return "user-save";
    }

    @RequestMapping(value = "/saveUser")
    public String doSaveUser(Model model, @ModelAttribute User user, HttpSession session) {
        String token = String.valueOf(session.getAttribute("token"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> entity = new HttpEntity<User>(user, headers);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(URL_API_USER, HttpMethod.POST, entity, String.class);

        return "redirect:/userInfo";
    }

    @RequestMapping(value = "/user-update/{id}")
    public String updateUser(Model model, @PathVariable int id, HttpSession session) {
        String token = String.valueOf(session.getAttribute("token"));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap<String, User> userObject = restTemplate.exchange(URL_API_USER + id, HttpMethod.GET, entity, LinkedHashMap.class).getBody();
        List<Object> list = new ArrayList<Object>();

        for (Map.Entry<String, User> map : userObject.entrySet()) {
            list.add(map.getValue());
        }
        model.addAttribute("user", list);
        return "user-update";
    }

    @RequestMapping(value = "/updateUser/{id}")
    public String doUpdateUser(Model model, @PathVariable int id, @ModelAttribute User user, HttpSession session) {
        String token = String.valueOf(session.getAttribute("token"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(URL_API_USER + id, HttpMethod.PUT, entity, String.class);

        return "redirect:/userInfo";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable int id, HttpSession session) {
        String token = String.valueOf(session.getAttribute("token"));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity entity = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        String error = restTemplate.exchange(URL_API_USER + id, HttpMethod.DELETE, entity, String.class).getBody();
        System.out.println("Error = " + error);
        return "redirect:/userInfo";
    }


    @RequestMapping(value = "/403")
    public String errorPage(Model model, Principal principal) {
            String str = "Hi " + principal.getName() + "<br/>You do not have permission access this page!";
            model.addAttribute("error", str);
        return "/403-page";
    }
}
