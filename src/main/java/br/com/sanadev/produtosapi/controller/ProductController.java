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


    //Salva e redireciona
    @PostMapping("/product")
    public String save(@ModelAttribute Product prod){
          prodRepo.save(prod);
        return "redirect:/products/list";
        }

    //Funcionando
    @GetMapping("{id}")
    public Product findById(@PathVariable("id") long id){
        return (Product) prodRepo.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id){
        prodRepo.deleteById(id);
        return "redirect:/products/list";
    }

    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("products",prodRepo.findAll());
        return "all-products";
    }

    @PutMapping
    public void update(@RequestBody Product p){
        prodRepo.save(p);
    }

    @GetMapping("search")
    public List<Product> search(@RequestParam("name") String name){
           return prodRepo.findByName(name);
    }
}


