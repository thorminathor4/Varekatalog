package com.example.varekatalog.Controller;

import com.example.varekatalog.Model.Product;
import com.example.varekatalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String frontPage(Model uiModel){
        uiModel.addAttribute("products",productService.loadAll());
        return "/frontPage";
    }

    @GetMapping("createProduct")
    public String createProduct(){
        return "/createProduct";
    }

    @PostMapping("createProduct")
    public String createProduct(@ModelAttribute Product p){
        productService.create(p);
        return "redirect:/";
    }

}
