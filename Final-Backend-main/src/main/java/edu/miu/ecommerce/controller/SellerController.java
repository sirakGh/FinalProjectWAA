package edu.miu.ecommerce.controller;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.model.NewProductRequest;
import edu.miu.ecommerce.model.OrderStatusRequest;
import edu.miu.ecommerce.service.ProductService;
import edu.miu.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin("http://localhost:3000")
@RestController
public class SellerController {

    @Autowired
    SellerService sellerService;

    @Autowired
    ProductService productService;

    @GetMapping("/sellers")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @PatchMapping("/sellers/{id}/approve")
    public Seller approve(@PathVariable long id){
        return sellerService.approveSeller(id);
    }

    @GetMapping("/sellers/{id}")
    public Seller getSellerById(@PathVariable long id) {
        return sellerService.getSellerById(id);
    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@PathVariable long id) {
        sellerService.deleteSeller(id);
    }

    @PostMapping("/sellers/{id}/products")
    public void addProduct(@PathVariable long id, @RequestBody NewProductRequest product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setOrders(null);
        newProduct.setReviews(null);
        sellerService.addProduct(newProduct, id);
    }

    @GetMapping("/sellers/{id}/products")
    public Set<Product> getProducts(@PathVariable long id) {
        return sellerService.findProducts(id);
    }

//  @GetMapping("/sellers/{id}/followers") // get followers
}
