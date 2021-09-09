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

    public Product read(int id){ return repo.read(id); }

    public void update(Product p){ repo.update(p); }

    public void delete(int id){ repo.delete(id); }

}
