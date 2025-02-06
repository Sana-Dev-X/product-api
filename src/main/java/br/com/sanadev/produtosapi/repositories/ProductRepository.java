package br.com.sanadev.produtosapi.repositories;

import br.com.sanadev.produtosapi.model.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Id> {
    Optional<Object> findById(long id);
}
