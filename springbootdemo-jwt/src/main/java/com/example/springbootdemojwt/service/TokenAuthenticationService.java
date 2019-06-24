package com.example.springbootdemojwt.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;

/* ghi "Authorization string" (chuỗi ủy quyền) vào Response Header để trả về cho Client
   Chuỗi ủy quyền này có tác dụng trong một khoảng thời gian (10 ngày). Điều này có nghĩa Client chỉ cần login một
   và có được "chuỗi ủy quyền" và có thể sử dụng nó trong khoảng thời gian nói trên. Khi "chuỗi ủy quyền" hết hạn sử dụng
   Client phải login lại để có được chuỗi ủy quyền.
*
*/
public class TokenAuthenticationService {
    public static final String USERNAME = "username";
    static final long EXPIRE_TIME = 864000000; // 10 days
    static final String SECRET_KEY = "11111111111111111111111111111111";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse response, String username) throws KeyLengthException {
//        String JWT = Jwts.builder().setSubject(username)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
//                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
//        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        String token = null;
        try {
            //
            // Create HMAC signer
            JWSSigner signer = new MACSigner(generateShareSecret());

            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USERNAME, username);
            builder.expirationTime(generateExpirationDate()); //

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

    public static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = null;
            try {
                // parse the token
                JWTClaimsSet claims = getClaimsFormToken(token);
                user = claims.getStringClaim(USERNAME);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            String user = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) : null;
        }
        return null;
    }

    private static JWTClaimsSet getClaimsFormToken(String token) {
        JWTClaimsSet claims = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            claims = signedJWT.getJWTClaimsSet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    private static byte[] generateShareSecret() {
        // Generate 256-bit (32-byte) shared secret
        byte[] sharedSecret = new byte[32];
        sharedSecret = SECRET_KEY.getBytes();
        return sharedSecret;
    }

    private static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRE_TIME);
    }
}
