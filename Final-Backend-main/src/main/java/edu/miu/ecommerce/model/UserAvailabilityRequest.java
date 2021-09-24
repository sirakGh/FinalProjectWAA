package edu.miu.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAvailabilityRequest {

    private String username;
    private boolean isAvailable;
}
