package edu.miu.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

    private String username;
    private String password;
    private String fullName;
    private boolean isBuyer;
    private boolean isSeller;
}
