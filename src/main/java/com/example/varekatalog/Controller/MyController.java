package com.example.varekatalog.Controller;

import com.example.varekatalog.Model.Product;
import com.example.varekatalog.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model uiModel){
        uiModel.addAttribute("products",productService.loadAll());
        return "/frontPage";
    }

    @GetMapping("/frontPage")
    public String frontPage(Model uiModel){
        uiModel.addAttribute("products",productService.loadAll());
        return "/frontPage";
    }

    @GetMapping("/createProduct")
    public String createProduct(){
        return "/createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product p){
        productService.create(p);
        return "redirect:/frontPage";
    }

    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, Model uiModel){
        uiModel.addAttribute("product",productService.read(id));
        return "/updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product p){
        productService.update(p);
        return "redirect:/frontPage";
    }

}
