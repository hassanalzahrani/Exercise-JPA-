package com.example.ecommercewebsite.Rpository;

import com.example.ecommercewebsite.Modell.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
}
