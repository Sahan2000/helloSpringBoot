package lk.ijse.gdse65.aad.HelloSoringBoot.services.impl;

import lk.ijse.gdse65.aad.HelloSoringBoot.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTServiceIMPL implements JWTService {
    @Override
    public String extractUserName(String token) {
        return null;
    }

    @Override
    public String generateToken(UserDetails user) {
        return null;
    }

    @Override
    public boolean isTokenValid(String token, UserDetails user) {
        return false;
    }
}
