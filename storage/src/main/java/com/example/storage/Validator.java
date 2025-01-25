package com.example.storage;

import com.example.storage.models.ProductModel;
import com.example.storage.repositories.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Validator {

    @Autowired
    ProductRepos productRepos;

    public boolean validateIdentArticle(Long article){
        return productRepos.findByArticle(article) != null;
    }


    public boolean baseValidate(ProductModel product){
        return validateNull(product.getArticle()) | validateNull(product.getCnt()) | validateNull(product.getName()) | validateNull(product.getProductType()) | validateNull(product.getPrice())
                | validateVoid(product.getName()) | validateVoid(product.getCnt()) | validateVoid(product.getPrice()) | validateVoid(product.getDescription());
    }


    private boolean validateNull(Object o){
        return o == null;
    }

    private boolean validateVoid(Object o){
        return String.valueOf(o).isEmpty();
    }
}
