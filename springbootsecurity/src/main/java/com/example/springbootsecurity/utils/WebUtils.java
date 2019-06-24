package com.example.springbootsecurity.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class WebUtils {
    public static String toString(User user) {
        StringBuffer sb = new StringBuffer();
        sb.append("UserName: ").append(user.getUsername());

        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append("");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    System.out.println(sb.toString());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                    System.out.println(sb.toString());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
