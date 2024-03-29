package lk.ijse.gdse65.aad.HelloSoringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
