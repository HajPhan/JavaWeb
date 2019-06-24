package com.example.springbootjwtjpasecurity.service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationService {
    public static final String USERNAME = "username";
    static final long EXPIRE_TIME = 864000000; // 10 days
    static final String SECRET_KEY = "11111111111111111111111111111111";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse response, String username) {
        String token = null;
        try {
            // Create HMAC signer
            JWSSigner signer = new MACSigner(generateShareSecret());

            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USERNAME, username);
            builder.expirationTime(generateExpirationDate());

            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

            // Apply the HMAC protection
            signedJWT.sign(signer);

            // Serialize to compact form, produces something like
            // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
            token = signedJWT.serialize();
            response.addHeader(HEADER_STRING, token);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Get Authentication
    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = null;
            try {
                // parse the token
                JWTClaimsSet claimsSet = getClaimsFormToken(token);
                user = claimsSet.getStringClaim(USERNAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
        }
        return null;
    }

    private static byte[] generateShareSecret() {
        // Generate 256-bit (32-byte) shared secret
        byte[] shareSecret = new byte[32];
        shareSecret = SECRET_KEY.getBytes();
        return shareSecret;
    }

    //
    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRE_TIME);
    }

    // Get UserName From Token
    public static JWTClaimsSet getClaimsFormToken(String token) {
        JWTClaimsSet claimsSet = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            claimsSet = signedJWT.getJWTClaimsSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimsSet;
    }


}
