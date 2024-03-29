package lk.ijse.gdse65.aad.HelloSoringBoot.services;

import lk.ijse.gdse65.aad.HelloSoringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSoringBoot.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(UserDTO user);
    UserDetailsService userDetailsService();
}
