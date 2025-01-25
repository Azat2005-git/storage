package com.example.storage.repositories;

import com.example.storage.enums.ProductType;
import com.example.storage.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepos extends JpaRepository<ProductModel, String> {
    @Override
    public List<ProductModel> findAll();

    ProductModel findByArticle(Long article);
}
