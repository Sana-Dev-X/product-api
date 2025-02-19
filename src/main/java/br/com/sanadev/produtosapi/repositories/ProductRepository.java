package br.com.sanadev.produtosapi.repositories;

import br.com.sanadev.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
