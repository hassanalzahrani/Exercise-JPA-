package com.example.ecommercewebsite.Rpository;

import com.example.ecommercewebsite.Modell.FavoriteList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FavoriteListRepository  extends JpaRepository<FavoriteList, Integer> {
}
