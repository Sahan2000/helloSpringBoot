package lk.ijse.gdse65.aad.HelloSoringBoot.services.impl;

import lk.ijse.gdse65.aad.HelloSoringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSoringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSoringBoot.entity.Role;
import lk.ijse.gdse65.aad.HelloSoringBoot.repostory.UserDao;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignIn;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignUp;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.response.JWTAuthResponse;
import lk.ijse.gdse65.aad.HelloSoringBoot.services.AuthenticationService;
import lk.ijse.gdse65.aad.HelloSoringBoot.services.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDao user;
    private final JWTService jwtService;
    private final ConversionData map;
    @Value("${token.key}")
    private String jwtKey;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JWTAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword())
        );
        var userByEmail = user.findByEmail(signIn.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        var token = jwtService.generateToken(userByEmail);
        return JWTAuthResponse.builder().token(token).build();
    }

    @Override
    public JWTAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .email(signUp.getEmail())
                .firstName(signUp.getFirstName())
                .lastName(signUp.getLastName())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        var savedUser = user.save(map.convertToUserEntity(buildUser));
        var genToken = jwtService.generateToken(savedUser);
        return JWTAuthResponse.builder().token(genToken).build();
    }
}
