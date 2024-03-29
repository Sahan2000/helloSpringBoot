package lk.ijse.gdse65.aad.HelloSoringBoot.conversion;

import lk.ijse.gdse65.aad.HelloSoringBoot.dto.CustomerDTO;
import lk.ijse.gdse65.aad.HelloSoringBoot.entity.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConversionData {
    final private ModelMapper modelMapper;
    //Student Obj mapping
    public CustomerDTO convertToCustomerDTO(CustomerEntity customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerEntity convertToCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

}
