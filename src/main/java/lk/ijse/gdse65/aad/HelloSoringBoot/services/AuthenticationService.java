package lk.ijse.gdse65.aad.HelloSoringBoot.services;

import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignIn;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignUp;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.response.JWTAuthResponse;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignIn signIn);
    JWTAuthResponse signUp(SignUp signUp);
}
