package com.example.varekatalog.Reposetory;

import com.example.varekatalog.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {

    @Autowired
    JdbcTemplate database;

    public List<Product> loadAll(){
        String sql="SELECT * FROM products";
        RowMapper<Product> rowMapper=new BeanPropertyRowMapper<>(Product.class);
        return database.query(sql,rowMapper);
    }

    public void create(Product p){
        String sql="INSERT INTO products (name,price) VALUES (?,?)";
        database.update(sql,p.getName(),p.getPrice());
    }

    public Product read(int id){
        String sql="SELECT * FROM products WHERE id = ?";
        RowMapper<Product> rowMapper=new BeanPropertyRowMapper<>(Product.class);
        return database.queryForObject(sql,rowMapper,id);
    }

    public void update(Product p){
        String sql="UPDATE products SET name=?, price=? WHERE id = ?";
        database.update(sql,p.getName(),p.getPrice(),p.getId());
    }

}
