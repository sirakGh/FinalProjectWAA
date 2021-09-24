package edu.miu.ecommerce.model;

import edu.miu.ecommerce.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddressRequest {

    private Address shippingAddress;
    private Address billingAddress;
}
