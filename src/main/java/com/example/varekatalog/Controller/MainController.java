package com.example.varekatalog.Controller;

import com.example.varekatalog.Model.Product;
import com.example.varekatalog.Reposetory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/")
    public String index(Model uiModel){
        uiModel.addAttribute("products",productRepo.readAll());
        return "forside";
    }

    @GetMapping("/forside")
    public String frontPage(Model uiModel){
        uiModel.addAttribute("products",productRepo.readAll());
        return "forside";
    }

    @GetMapping("/tilføjVare")
    public String createProduct(){
        return "tilføjVare";
    }

    @PostMapping("/tilføjVare")
    public String createProduct(@ModelAttribute Product p){
        productRepo.create(p);
        return "redirect:/forside";
    }

    @GetMapping("/redigerVare/{id}")
    public String updateProduct(@PathVariable("id") int id, Model uiModel){
        uiModel.addAttribute("product",productRepo.read(id));
        return "redigerVare";
    }

    @PostMapping("/redigerVare")
    public String updateProduct(@ModelAttribute Product p){
        productRepo.update(p);
        return "redirect:/forside";
    }

    @GetMapping("/sletVare/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productRepo.delete(id);
        return "redirect:/forside";
    }
}
