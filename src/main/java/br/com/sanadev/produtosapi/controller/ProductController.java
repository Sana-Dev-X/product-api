package br.com.sanadev.produtosapi.controller;

import br.com.sanadev.produtosapi.model.Product;
import br.com.sanadev.produtosapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    @PostMapping
    public void save(@RequestBody Product prod){
        System.out.println("Recebido o produto: "+prod);
        prodRepo.save(prod);
        }

    @GetMapping("{id}")
    public Product findById(@PathVariable("id") long id){
        return (Product) prodRepo.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id){
        prodRepo.deleteById(id);
    }

    @GetMapping("list")
    public List<Product> getList(){
        return prodRepo.findAll();
    }
}


