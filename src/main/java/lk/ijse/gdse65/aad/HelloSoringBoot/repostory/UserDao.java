package lk.ijse.gdse65.aad.HelloSoringBoot.repostory;

import lk.ijse.gdse65.aad.HelloSoringBoot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
