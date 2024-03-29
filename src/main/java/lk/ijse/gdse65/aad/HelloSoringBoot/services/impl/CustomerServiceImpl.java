package lk.ijse.gdse65.aad.HelloSoringBoot.services.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse65.aad.HelloSoringBoot.conversion.ConversionData;
import lk.ijse.gdse65.aad.HelloSoringBoot.dto.CustomerDTO;
import lk.ijse.gdse65.aad.HelloSoringBoot.entity.CustomerEntity;
import lk.ijse.gdse65.aad.HelloSoringBoot.repostory.CustomerDao;
import lk.ijse.gdse65.aad.HelloSoringBoot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ConversionData convert;
    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return convert.convertToCustomerDTO(customerDao.save(convert.convertToCustomerEntity(customerDTO)));
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerDao.findById(Integer.valueOf(id));

        if(tmpCustomer.isPresent()){
            tmpCustomer.get().setFirstName(customerDTO.getFirstName());
            tmpCustomer.get().setLastName(customerDTO.getLastName());
            tmpCustomer.get().setEmail(customerDTO.getEmail());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        customerDao.deleteById(Integer.valueOf(id));
    }
}
