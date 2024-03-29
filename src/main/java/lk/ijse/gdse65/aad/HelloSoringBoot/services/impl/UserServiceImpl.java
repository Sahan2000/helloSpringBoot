package lk.ijse.gdse65.aad.HelloSoringBoot.services.impl;

import lk.ijse.gdse65.aad.HelloSoringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSoringBoot.dto.UserDTO;
import lk.ijse.gdse65.aad.HelloSoringBoot.entity.UserEntity;
import lk.ijse.gdse65.aad.HelloSoringBoot.repostory.UserDao;
import lk.ijse.gdse65.aad.HelloSoringBoot.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final private UserDao userDao;
    private final ConversionData map;
    @Override
    public void save(UserDTO user) {
        map.convertToUserDTO(userDao.save(map.convertToUserEntity(user)));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userDao.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
    }
}
