package lk.ijse.gdse65.aad.HelloSoringBoot.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String extractUserName(String token);
    String generateToken(UserDetails user);
    boolean isTokenValid(String token, UserDetails user);
}
