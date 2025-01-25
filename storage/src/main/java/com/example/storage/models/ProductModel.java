package com.example.storage.models;

import com.example.storage.enums.ProductType;
import com.example.storage.repositories.ProductRepos;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Storage")
public class ProductModel {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column
    private String name;
    @Column(unique = true)
    private Long article;
    @Column
    private String description;
    @Column
    private ProductType type;
    @Column
    private Double price;
    @Column
    private Long cnt;
    @Column
    private Date lastUpdate;
    @Column
    private Date timeCreated;

    public ProductModel(String name, Long article, String description, ProductType type, Double price, Long cnt, Date lastUpdate, Date timeCreated) {
        this.name = name;
        this.article = article;
        this.description = description;
        this.type = type;
        this.price = price;
        this.cnt = cnt;
        this.lastUpdate = lastUpdate;
        this.timeCreated = timeCreated;
    }

    public ProductModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArticle() {
        return article;
    }

    public void setArticle(Long article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return type;
    }

    public void setProductType(ProductType productType) {
        this.type = productType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }
}
