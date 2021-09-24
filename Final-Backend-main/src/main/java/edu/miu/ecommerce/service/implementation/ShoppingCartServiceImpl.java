package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.ShoppingCart;
import edu.miu.ecommerce.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public Product addProductToShoppingCart(Product product) {
        return null;
    }

    @Override
    public ShoppingCart addShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public void deleteShoppingCart(ShoppingCart shoppingCart) {

    }
}
