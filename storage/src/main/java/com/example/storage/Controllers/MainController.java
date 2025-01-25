package com.example.storage.Controllers;


import com.example.storage.Validator;
import com.example.storage.enums.ProductType;
import com.example.storage.models.ProductModel;
import com.example.storage.repositories.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProductRepos productRepos;
    @Autowired
    private Validator validator;



    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("modelList", productRepos.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductModel newProduct) {

        newProduct.setTimeCreated(new Date());
        newProduct.setLastUpdate(new Date());

        if (validator.baseValidate(newProduct) || validator.validateIdentArticle(newProduct.getArticle())) {
            return "redirect:/";
        }

        productRepos.save(newProduct);

        return "redirect:/";

    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        model.addAttribute("productModel", new ProductModel());
        return "create-product";
    }
    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable String id, Model model) {
        ProductModel productModel = productRepos.findById(id).orElse(null);

        if (productModel == null) {
            return "redirect:/";
        }

        model.addAttribute("productModel", productModel);
        return "update-product";
    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable String id, @ModelAttribute ProductModel productModel) {
        ProductModel oldProductModel = productRepos.findById(id).orElse(null);

        if (oldProductModel == null || (!oldProductModel.getArticle().equals(productModel.getArticle()) && validator.validateIdentArticle(productModel.getArticle())))
            return "redirect:/";
        productModel.setTimeCreated(oldProductModel.getTimeCreated());
        oldProductModel = productModel;
        oldProductModel.setLastUpdate(new Date());

        if (validator.baseValidate(oldProductModel)) {
            return "redirect:/";
        }

        productRepos.save(oldProductModel);
        return "redirect:/";
    }
    @PostMapping("/delete/{id}")
    public String updateProduct(@PathVariable String id) {
        try{
            productRepos.deleteById(id);
        }catch (Exception e){
        }
        return "redirect:/";
    }

}