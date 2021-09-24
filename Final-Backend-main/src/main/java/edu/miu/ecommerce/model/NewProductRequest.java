package edu.miu.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewProductRequest {


    private long id;
    private String name;
    private String description;
    private float price;
}
