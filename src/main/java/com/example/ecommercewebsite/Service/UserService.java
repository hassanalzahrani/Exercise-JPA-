package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.User;
import com.example.ecommercewebsite.Rpository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    ProductService productService;
private final UserRepository userRepository;
    ArrayList<User> users = new ArrayList<User>();

   public List<User> getUsers() {
       return userRepository.findAll();
   }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id, User user) {
        User u=userRepository.getById(id);
        if(u==null) {
            return false;
        }
        u.setPrime(user.isPrime());
        u.setId(user.getId());
        u.setBalance(user.getBalance());
        u.setRole(user.getRole());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());


        userRepository.save(u);
        return true;
    }

    public boolean subscribePrime(int userId) {
        for (User user : users) {
            if (user.getId() == userId && "customer".equals(user.getRole())) {
                user.setPrime(true);
                user.setBalance(user.getBalance() - 20);
                return true;
            }
        }
        return false;
    }


    public boolean deleteUser(Integer id) {
        User u =userRepository.getById(id);
        if(u ==null) {
            return false;
        }
        userRepository.delete(u);
        return true;
    }



}









