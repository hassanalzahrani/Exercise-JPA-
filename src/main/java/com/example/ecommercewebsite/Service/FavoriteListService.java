package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.FavoriteList;
import com.example.ecommercewebsite.Rpository.FavoriteListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FavoriteListService {


    private final FavoriteListRepository favoriteListRepository;





    public List<FavoriteList> getFavoriteLists() {
        return (List<FavoriteList>) favoriteListRepository.findAll();
    }


    public void addFavoriteLists(FavoriteList favoriteList) {
        favoriteListRepository.save(favoriteList);
    }


    public boolean deleteFavoriteLists (Integer id) {
        FavoriteList f = favoriteListRepository.delete(id);
        if (f == null) {
            return false;
        }
        favoriteListRepository.delete(f);
        return true;
    }
}