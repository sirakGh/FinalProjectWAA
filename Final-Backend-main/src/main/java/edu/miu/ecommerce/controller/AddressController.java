package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.domain.Address;
import edu.miu.ecommerce.model.AddressRequest;
import edu.miu.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PatchMapping("/addresses/{id}") // patch an address
    public Address updateAddress(@RequestBody AddressRequest addressRequest, @PathVariable long id){
        return addressService.updateAddress(addressRequest, id);
    }
    @DeleteMapping("/addresses/{id}") // delete an address
    public void deleteAddress(@PathVariable long id){
        addressService.deleteAddress(id);
    }
}
