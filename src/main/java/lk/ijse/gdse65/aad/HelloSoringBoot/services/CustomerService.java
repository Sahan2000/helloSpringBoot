package lk.ijse.gdse65.aad.HelloSoringBoot.services;

import lk.ijse.gdse65.aad.HelloSoringBoot.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
}
