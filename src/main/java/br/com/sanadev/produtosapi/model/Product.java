package br.com.sanadev.produtosapi.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + "\'" +
                ", name='" + name + "\'" +
                ", description='" + description + "\'" +
                ", price=" + price +
                '}';
    }

    public long getId() {
        return id;


    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
