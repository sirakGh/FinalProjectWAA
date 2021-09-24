package edu.miu.ecommerce.service;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.ShoppingCart;


public interface ShoppingCartService {


    Product addProductToShoppingCart(Product product);

    ShoppingCart addShoppingCart(ShoppingCart shoppingCart);

    void deleteShoppingCart(ShoppingCart shoppingCart);


}
