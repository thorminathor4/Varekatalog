package com.example.varekatalog.Service;

import com.example.varekatalog.Model.Product;
import com.example.varekatalog.Reposetory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    public List<Product> loadAll(){ return repo.loadAll(); }

    public void create(Product p){ repo.create(p); }

}
