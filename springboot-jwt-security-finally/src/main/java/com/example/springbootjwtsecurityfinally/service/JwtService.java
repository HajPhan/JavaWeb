package com.example.springbootjwtsecurityfinally.service;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    public static final String USERNAME = "username";
    public static final String SECRET_KEY = "11111111111111111111111111111111"; //32
    public static final int EXPIRE_TIME = 8640000;

    public String generateTokenLogin(String username) {
        String token = null;
        try {
            // Create MAC Signer
            JWSSigner signer = new MACSigner(generateShareSecret());

            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USERNAME, username);
            builder.claim("password", "123");
            builder.expirationTime(generateExpirationDate());

            getPasswordFromToken(token);

            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

            // Apply The HMAC protection
            signedJWT.sign(signer);

            // Serialize to compact form, produces something like
            // eyJhbGciOiJIUzI1NiJ9.SGVsbG8sIHdvcmxkIQ.onO9Ihudz3WkiauDO2Uhyuz0Y18UASXlSc1eS0NkWyA
            token = signedJWT.serialize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public byte[] generateShareSecret() {
        // Generate 256-bit (32-byte) shared secret
        byte[] sharedSecret = new byte[32];
        sharedSecret = SECRET_KEY.getBytes();
        return sharedSecret;
    }

    public Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRE_TIME);
    }

    public JWTClaimsSet getClaimsFormTocken(String token) {
        JWTClaimsSet claimsSet = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(generateShareSecret()); // tao key de map voi key tu token
            if (signedJWT.verify(verifier)) {
                claimsSet = signedJWT.getJWTClaimsSet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claimsSet;
    }


    // JWTClaimSet:
    // Get expiration tương ứng chuỗi token đã tạo trc đó
    public Date getExpirationDateFormToken(String token) {
        Date expiration = null;
        JWTClaimsSet claimsSet = getClaimsFormTocken(token);
        expiration = claimsSet.getExpirationTime();
        return expiration;
    }


    // Lấy thông tin username từ token
    public String getUsernameFormToken(String token) {
        String username = null;
        try {
            JWTClaimsSet claimsSet = getClaimsFormTocken(token);
            username = claimsSet.getStringClaim(USERNAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }

    // Lấy thông tin password từ token
    public void getPasswordFromToken(String token) {
        try {
            String password = null;
            JWTClaimsSet claimsSet = getClaimsFormTocken(token);
            password = claimsSet.getStringClaim("password");
            System.out.println("===============================| " + password + " ===========================> ");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return password;
    }

    //
    public boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFormToken(token);
        return expiration.before(new Date());
    }


    //
    public Boolean validateTokenLogin(String token) {
        if (token == null || token.trim().length() == 0) {
            return false;
        }

        String username = getUsernameFormToken(token);

        if (username == null || username.isEmpty()) {
            return false;
        }

        if (isTokenExpired(token)) {
            return false;
        }

        return true;
    }
}
