package br.com.sanadev.produtosapi.controller;

import br.com.sanadev.produtosapi.model.Product;
import br.com.sanadev.produtosapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    @PostMapping("/save")
    public Product save(@RequestBody Product prod) {
        return prodRepo.save(prod);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        prodRepo.deleteById(id);
    }

    @PutMapping("/edit/{id}")
    public Product edit(@PathVariable("id") long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = prodRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product p = optionalProduct.get();
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setDescription(product.getDescription());
            return prodRepo.save(p);
        } else {
            throw new RuntimeException("Product not found with id " + id);
        }
    }

    @GetMapping("/list")
    public List<Product> getList() {
        return prodRepo.findAll();
    }

    @GetMapping("/form")
    public Product form() {
        return new Product();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam("name") String name) {
        return prodRepo.findByName(name);
    }

}