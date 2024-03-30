package lk.ijse.gdse65.aad.HelloSoringBoot.controller;

import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignIn;
import lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure.SignUp;
import lk.ijse.gdse65.aad.HelloSoringBoot.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationService authenticationService;
    //signup
    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> signup(@RequestBody SignUp signup) {
        return ResponseEntity.ok(authenticationService.signUp(signup).toString());
    }
    //signin
    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody SignIn signin) {
        return ResponseEntity.ok(authenticationService.signIn(signin).toString());
    }
}
