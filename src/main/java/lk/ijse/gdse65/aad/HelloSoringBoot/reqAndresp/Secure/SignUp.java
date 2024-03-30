package lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
}
