package lk.ijse.gdse65.aad.HelloSoringBoot.repostory;

import lk.ijse.gdse65.aad.HelloSoringBoot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {
}
