package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.*;
import com.example.ecommercewebsite.Rpository.CategoryRepository;
import com.example.ecommercewebsite.Rpository.MerchantStockRepository;
import com.example.ecommercewebsite.Rpository.ProductRepository;
import com.example.ecommercewebsite.Rpository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {





    private final ProductRepository productRepository;
private final CategoryRepository categoryRepository;
private final UserRepository userRepository;
private final MerchantStockRepository merchantStockRepository;


    ArrayList<Product> products = new ArrayList<Product>();
    private final UserService userService;
    private final MerchantStockService merchantStockService;

 public List<Product> getProducts() {
     return productRepository.findAll();
 }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean updateProduct(Integer id, Product product) {
        Product p=productRepository.getById(id);
        if(p==null) {
            return false;
        }
        p.setName(product.getName());
        p.setCategoryID(product.getCategoryID());
        p.setPrice(product.getPrice());

        productRepository.save(p);
        return true;
    }
    public boolean deleteProduct(Integer id) {
        Product p =productRepository.getById(id);
        if(p ==null) {
            return false;
        }
        productRepository.delete(p);
        return true;
    }
//======================================
// I add the discount to the userBuyProduct

    public int userBuyProduct(int productId, int userId, Integer merchantId,double discountPercentage) {

        Product p=productRepository.getById(productId);
        User u=userRepository.getById(userId);
            MerchantStock m=merchantStockRepository.getReferenceById(merchantId);

            ///3 if
        for (MerchantStock merchantStock : merchantStockRepository.findAll()) {
            if (merchantId == m.getMerchantid()) {
                if (productId == m.getProductid()) {
                            if (m.getStock() > 0) {
                            //    for (Product p : products) {
                              //      if (p.getId() == productId) {
                                        if (discountPercentage > 0 && discountPercentage <= 100) {
                                            int originalPrice = p.getPrice();
                                            int discountAmount = (int) (originalPrice * (discountPercentage / 100.0));
                                            p.setPrice(originalPrice - discountAmount);
                                            if (u.getBalance() >= p.getPrice()) {
                                                m.setStock(m.getStock() - 1);
                                                u.setBalance(u.getBalance() - p.getPrice());
                                                userRepository.save(u);
                                                productRepository.save(p);
                                                merchantStockRepository.save(m);
                                                return 5;
                                            }
                                        }
                                        return 4;
                                    }
                                }
                            }
                            return 3;
                        }
                        return 2;
                    }
                }




