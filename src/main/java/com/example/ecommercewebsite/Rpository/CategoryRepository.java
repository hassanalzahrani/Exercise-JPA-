package com.example.ecommercewebsite.Rpository;

import com.example.ecommercewebsite.Modell.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
