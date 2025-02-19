package br.com.sanadev.produtosapi.controller;

import br.com.sanadev.produtosapi.model.Product;
import br.com.sanadev.produtosapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    @PostMapping("/save")
    public String save(@ModelAttribute Product prod){
        prodRepo.save(prod);
        return "redirect:/products/list";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        prodRepo.deleteById(id);
        return "redirect:/products/list";
    }

    //corrigir
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, @ModelAttribute Product product){
        Product p = prodRepo.findById(id).get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());
        prodRepo.save(p);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("products",prodRepo.findAll());
        return "all-products";
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("product", new Product());
        return "form";
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam("name") String name){
           return prodRepo.findByName(name);
    }
}


