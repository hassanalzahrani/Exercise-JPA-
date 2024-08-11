package com.example.ecommercewebsite.Service;

import com.example.ecommercewebsite.Modell.MerchantStock;
import com.example.ecommercewebsite.Rpository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MerchantStockService {


    private final MerchantStockRepository merchantStockRepository;


    @Autowired
    private MerchantService merchantService;
    @Autowired
    private ProductService productService;
    ArrayList<MerchantStock> merchantStocks = new ArrayList<MerchantStock>();

    public List<MerchantStock> getMerchantStocks() {
        return merchantStockRepository.findAll();
    }



    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStockRepository.save(merchantStock);
    }

    public boolean updateMerchanrStock(Integer id, MerchantStock merchantStock) {
        MerchantStock m=merchantStockRepository.getById(id);
        if(m==null) {
            return false;
        }
        m.setStock(merchantStock.getStock());
        m.setId(merchantStock.getId());
        m.setProductid(merchantStock.getProductid());
        m.setMerchantid(merchantStock.getMerchantid());
        merchantStockRepository.save(m);
        return true;
    }
    public boolean deleteMerchantStock(Integer id) {
        MerchantStock m =merchantStockRepository.getById(id);
        if(m ==null) {
            return false;
        }
        merchantStockRepository.delete(m);
        return true;
    }

}

