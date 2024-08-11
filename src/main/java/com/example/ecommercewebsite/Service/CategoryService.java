package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.Category;
import com.example.ecommercewebsite.Rpository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
 ArrayList<Category> categories = new ArrayList<Category>();

 private final CategoryRepository categoryRepository;


    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public boolean updateCategory(Integer id, Category category) {
        Category c=categoryRepository.getById(id);
        if(c==null) {
            return false;
        }

        c.setName(category.getName());
        c.setID(category.getID());

        categoryRepository.save(c);
        return true;
    }

    public boolean deleteCategory(Integer id) {
        Category c =categoryRepository.getById(id);
        if(c ==null) {
            return false;
        }
        categoryRepository.delete(c);
        return true;
    }

}




