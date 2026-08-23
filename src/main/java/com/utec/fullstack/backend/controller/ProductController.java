package com.utec.fullstack.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable("id") String id) {
        //SELECT * FROM PRODUCTS WHERE id = :id LIMIT 1
        return new Product(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        //SELECT * FROM PRODUCTS
        return Collections.singletonList(new Product("MANZANA"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        // INSERT INTO PRODUCTS VALUES(name)
        return new Product(product.getName() + " " + product.getName());
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        // UPDATE PRODUCTS SET name = :name where id = :id
        return new Product((id + product.getName()).toLowerCase().replace("a", "4"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") String id) {
        // DELETE FROM PRODUCTS WHERE id = :id
    }

    @DeleteMapping("{id}/return")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void returnProduct(@PathVariable("id") String id) {

    }

    @GetMapping("{id}/stock")
    public Double getStock(@PathVariable("id") String id) {
        // SELECT s.* FROM PRODUCTS p JOIN STOCK s on (p.id=s.product_id)
        return 20.0;
    }

    @PostMapping("{id}/stock/{stock}/validate")
    public Boolean getStock(@PathVariable("id") String id,
                            @PathVariable("stock") Double stock) {
        return stock < 20.0;
    }

}
