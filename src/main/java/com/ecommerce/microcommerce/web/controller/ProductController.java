package com.ecommerce.microcommerce.web.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.dao.ProductDaoImpl;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    //Récupérer la liste des produits
    @GetMapping(value="Produits")
    public List<Product>listeProduits(){
        return productDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value="Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping(value = "/Produits")
    public void ajouterProduit(@RequestBody Product product){
        productDao.save(product);
    }
}
