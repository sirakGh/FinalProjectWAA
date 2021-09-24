package edu.miu.ecommerce.service.implementation;

import edu.miu.ecommerce.domain.Order;
import edu.miu.ecommerce.domain.OrderStatus;
import edu.miu.ecommerce.domain.Product;
import edu.miu.ecommerce.domain.Seller;
import edu.miu.ecommerce.repository.OrderDAO;
import edu.miu.ecommerce.repository.ProductDAO;
import edu.miu.ecommerce.repository.SellerDAO;
import edu.miu.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerDAO sellerDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Override
    public List<Seller> getAllSellers() {
        return StreamSupport.stream(sellerDAO.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Seller getSellerById(long id) {
        return sellerDAO.findById(id).orElseThrow();
    }

    @Override
    public Seller addSeller(Seller seller) {
        seller.setApproved(false);
        return sellerDAO.save(seller);
    }

    @Override
    public void deleteSeller(long id) {
        sellerDAO.deleteById(id);
    }

    @Override
    public Set<Product> findProducts(long id) {
        return productDAO.findAllBySeller(getSellerById(id));
    }

    @Override
    public Product addProduct(Product product, long id) {
        Seller seller = getSellerById(id);
        product.setSeller(seller);
        return productDAO.save(product);
    }

    @Override
    public Seller approveSeller(long id) {
       Seller seller = getSellerById(id);
       seller.setApproved(true);
       return sellerDAO.save(seller);
    }

}
