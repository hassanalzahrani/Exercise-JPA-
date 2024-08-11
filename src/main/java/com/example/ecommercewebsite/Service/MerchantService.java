package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.Merchant;
import com.example.ecommercewebsite.Rpository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

ArrayList<Merchant> merchants = new ArrayList<>();
public List<Merchant> getMerchants() {
    return merchantRepository.findAll();
}
public Merchant addMerchant(Merchant merchant) {
 return merchantRepository.save(merchant);
}

    public boolean updateMerchant(Integer id, Merchant merchant) {
        Merchant m=merchantRepository.getById(id);
        if(m==null) {
            return false;
        }
        m.setName(merchant.getName());
        m.setId(merchant.getId());


 merchantRepository.save(m);
        return true;
    }
    public boolean deleteMerchant(Integer id) {
        Merchant m =merchantRepository.getById(id);
        if(m ==null) {
            return false;
        }
        merchantRepository.delete(m);
        return true;
    }

}
