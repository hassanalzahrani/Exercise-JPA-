package com.example.ecommercewebsite.Rpository;

import com.example.ecommercewebsite.Modell.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
