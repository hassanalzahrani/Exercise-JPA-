package com.example.ecommercewebsite.Rpository;

import com.example.ecommercewebsite.Modell.MerchantStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantStockRepository extends JpaRepository<MerchantStock, Integer> {

}
