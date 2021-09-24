package edu.miu.ecommerce.model;

import edu.miu.ecommerce.domain.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStatusRequest {

    private OrderStatus status;
}
