package com.example.ecommercewebsite.Modell;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;




    @NotNull(message = "ID should not be empty")
    private int id;
    @NotEmpty(message = "password should not be empty")
    @Min(value = 7,message = "password have to be more than 6 length long")

   private String username;
   private String password;
   private String email;
    @Pattern(regexp = "^(supervisor|coordinator|customer)$")
   private String role;
    @NotNull(message = "balance should not be empty")
    @Positive(message = "balance should be positive")
   private int balance;

    private boolean isPrime;


}
