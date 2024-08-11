package com.example.ecommercewebsite.Controler;

import com.example.ecommercewebsite.ApiResponse.ApiResponse;
import com.example.ecommercewebsite.Modell.FavoriteList;
import com.example.ecommercewebsite.Service.FavoriteListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/favorite")
public class FavoriteListController {
    private final FavoriteListService favoriteListService;

    @GetMapping("/get")
    public ResponseEntity getFavoriteList(@PathVariable int userId) {
        List<FavoriteList> favoriteLists = favoriteListService.getFavoriteLists();
        return ResponseEntity.status(200).body(favoriteLists);
    }

    @PostMapping("/add")
    public ResponseEntity addFavorite(@Valid @RequestBody FavoriteList favoriteList, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        favoriteListService.addFavoriteLists(favoriteList);
        return ResponseEntity.status(200).body(new ApiResponse("Product added to favorite list successfully"));
    }

}
