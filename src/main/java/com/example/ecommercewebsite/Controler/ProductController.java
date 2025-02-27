package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.Product;
import com.example.ecommercewebsite.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity getProduct(){
        ArrayList<Product> products = (ArrayList<Product>) productService.getProducts();
        return ResponseEntity.status(200).body(products);
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body("Product added");
    }
    @PutMapping("/update/{id}")
public ResponseEntity updateProduct(@PathVariable Integer id, @Valid@RequestBody Product product,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = productService.updateProduct(id, product);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Product updated"));

        }
        return ResponseEntity.status(404).body("Product not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Product deleted");

        }
        return ResponseEntity.status(404).body(new ApiResponse("Product not found"));
    }
    @PostMapping("buy/{productId}/{userId/{merchantId}}")
    public ResponseEntity buyProduct(@PathVariable int productId, @PathVariable int userId,@PathVariable int merchantId, @PathVariable double discountPercentage) {
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==0){
            return ResponseEntity.status(400).body(new ApiResponse("merchantId not found"));

        }
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==1){
            return ResponseEntity.status(400).body(new ApiResponse("product ID not found"));
        }
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==2){
            return ResponseEntity.status(400).body(new ApiResponse("user ID not found"));
        }
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==3){
            return ResponseEntity.status(400).body(new ApiResponse("product not found in stock"));
        }
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==4){
            return ResponseEntity.status(400).body(new ApiResponse("your blance is  enough to buy this product"));
        }
        if (productService.userBuyProduct(productId, userId, merchantId,discountPercentage)==5){
            return ResponseEntity.status(200).body(new ApiResponse("your purchase is  completed"));
        }
        return ResponseEntity.status(404).body(new ApiResponse("bad request"));


    }



    }

