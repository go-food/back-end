package gofood.auth.util;

import gofood.exception.HttpUnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    public static String COOKIE_NAME = "token";
    private static String SECRET_KEY = "devoncloud";

    public static String extractId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(String id) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, id);
    }

    private static String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static Boolean validateToken(String token, String id) {
        final String extractedId = extractId(token);
        return (extractedId.equals(id) && !isTokenExpired(token));
    }

    public static Cookie createCookie(String token) {
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setMaxAge(3600000);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        return cookie;
    }

    public static Cookie clearCookie() {
        Cookie cookie = new Cookie(COOKIE_NAME, null);
        cookie.setMaxAge(0);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        return cookie;
    }

    public static Integer getRequestUserId(HttpServletRequest request){
        Cookie cookie = WebUtils.getCookie(request, COOKIE_NAME);
        if (cookie == null) throw new HttpUnauthorizedException();
        String idString = extractId(cookie.getValue());
        if (idString == null) throw new HttpUnauthorizedException();
        return Integer.valueOf(idString);
    }
}