package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.AddressType;
import edu.miu.ecommerce.model.AddressRequest;
import edu.miu.ecommerce.repository.AddressDAO;
import edu.miu.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDAO addressDAO;

    @Override
    public void deleteAddress(long id) {
        addressDAO.deleteById(id);
    }

    @Override
    public Address updateAddress(AddressRequest addressRequest, long id) {
       Address address = addressDAO.findById(id).get();
       address.setCity(addressRequest.getCity());
       address.setState(addressRequest.getState());
       address.setZipCode(addressRequest.getZipCode());
       address.setAddressType(addressRequest.getAddressType());
       return addressDAO.save(address);
    }
}
