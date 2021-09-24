package edu.miu.ecommerce.model;

import edu.miu.ecommerce.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

    private String state;

    private String city;

    private int zipCode;

    private String country;

    private AddressType addressType;
}
