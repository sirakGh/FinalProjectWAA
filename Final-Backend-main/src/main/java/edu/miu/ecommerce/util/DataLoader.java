package edu.miu.ecommerce.util;

import edu.miu.ecommerce.domain.*;
import edu.miu.ecommerce.repository.*;
import edu.miu.ecommerce.service.BuyerService;
import edu.miu.ecommerce.service.ReviewService;
import edu.miu.ecommerce.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private SellerDAO sellerDAO;

    @Autowired

    private BuyerDAO buyerDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Autowired
    SellerService sellerService;

    @Autowired
    BuyerService buyerService;

    @Autowired
    ReviewService reviewService;

    @Override
    public void run(String... args) throws Exception {
        createRoles();
        createAdmins();
        createSellers();
        createBuyers();
        createProducts();
        createOrders();
        createReviews();
        createAddress();
    }

    private void createRoles(){
        Role roleAdmin = new Role(1,"ROLE_ADMIN", null);
        Role roleSeller = new Role(2,"ROLE_SELLER", null);
        Role roleBuyer = new Role(3,"ROLE_BUYER", null);

        roleDAO.saveAll(Arrays.asList(roleAdmin, roleSeller, roleBuyer));
        System.out.println(roleDAO.findAll().toString());
    }

    private void createSellers(){
        Seller seller = new Seller("sirak efrem", true, null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(2L).get());
        seller.setUsername("seller");
        seller.setPassword(new BCryptPasswordEncoder().encode("efrem"));
        seller.setRoles(roleSet);
        sellerDAO.saveAll(Arrays.asList(seller));
        StreamSupport.stream(sellerDAO.findAll().spliterator(),false)
                .forEach(seller1 -> System.out.println("Seller ID: " + seller1.getId() + " Seller Username: " + seller1.getUsername()));
        System.out.println("Seller Password: efrem");
    }

    private void createBuyers(){
        Buyer buyer = new Buyer(0,"adam adam",null,null,null,null,null);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(3L).get());
        buyer.setUsername("buyer");
        buyer.setPassword(new BCryptPasswordEncoder().encode("adam"));
        buyer.setRoles(roleSet);
        Buyer savedBuyer = buyerDAO.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(savedBuyer);
        shoppingCartDAO.save(shoppingCart);
        StreamSupport.stream(buyerDAO.findAll().spliterator(),false)
                .forEach(buyer1 -> System.out.println("Buyer ID: " + buyer1.getId() + " Buyer Username: " + buyer1.getUsername()));
        System.out.println("Buyer Password: adam");

    }

    private void createAdmins(){
        Admin admin = new Admin();
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDAO.findById(1L).get());
        admin.setUsername("admin");
        admin.setPassword(new BCryptPasswordEncoder().encode("sirak"));
        admin.setRoles(roleSet);
        adminDAO.save(admin);
        StreamSupport.stream(adminDAO.findAll().spliterator(),false)
                .forEach(admin1 -> System.out.println("Admin ID: " + admin1.getId() + " Admin Username: " + admin1.getUsername()));
        System.out.println("Admin Password: sirak");

    }

    private void createProducts(){

        Product product = new Product(1L,"AirPods","Wireless EarPhone", 220, null, null, null);
        Product product1 = new Product(2L,"iPhone 11","Smart Phone", 1100, null, null, null);
        Product product2 = new Product(3L,"MacBook Pro","Laptop", 2000, null, null, null);
        Product product3= new Product("iPhone 13 Pro","Smart Phone", 1500, null, null, null);
        Product product4= new Product(" iPad","Tablet", 589, null, null, null);
        Product product5 = new Product("Apple Watch","Smart Watch", 350, null, null, null);
        sellerService.addProduct(product1, 5L);
        sellerService.addProduct(product, 5L);
        sellerService.addProduct(product2, 5L);
        sellerService.addProduct(product3, 5L);
        sellerService.addProduct(product4, 5L);
        sellerService.addProduct(product5, 5L);
        System.out.println(productDAO.findAll().toString());
    }

    private void createOrders(){

        Optional<Buyer> buyer = buyerDAO.findById(6L);
        Optional<Product> product = productDAO.findById(8L);
        System.out.println(buyer.get());
        System.out.println(product.get());
        Order order = new Order();
        order.setStatus(OrderStatus.ORDERED);
        order.setProduct(product.get());
        order.setBuyer(buyer.get());
        orderDAO.save(order);
        System.out.println(order.toString());
        System.out.println(orderDAO.findAll().toString());
    }

    private void createReviews(){
        Review review = new Review();
        review.setContent("I am happy");
//        Review review1 = new Review();
//        review.setContent("I am Super excited....!!!");
//        buyerService.addReviewByBuyerId(review1,5, 4);
        buyerService.addReviewByBuyerId(review,6, 8);


    }

    private void createAddress(){
        Address address = new Address();
        address.setAddressType(AddressType.BILLING);
        address.setCountry("USA");
        address.setCity("Fairfield");
        address.setState("Iowa");
        address.setZipCode(52557);

        buyerService.addAddressToBuyer(address,6);


    }

}
