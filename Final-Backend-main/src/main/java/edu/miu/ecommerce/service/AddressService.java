package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.domain.AddressType;
import edu.miu.ecommerce.model.AddressRequest;

import java.util.List;


public interface AddressService {

    void deleteAddress(long id);

    Address updateAddress(AddressRequest addressRequest, long id);
}
