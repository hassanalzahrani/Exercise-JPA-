package com.example.ecommercewebsite.Modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class FavoriteList {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;




    @NotNull(message = "ID should not be empty")
    private int id;
    
    @NotNull(message = "user ID should not be empty")
    private int userId;
    
    @NotNull(message = "product ID should not be empty")
    private int productId;
}
