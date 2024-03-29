package lk.ijse.gdse65.aad.HelloSoringBoot.reqAndresp.Secure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignIn {
    private String email;
    private String password;
}
