package com.utec.fullstack.backend.controller;

import com.utec.fullstack.backend.controller.request.CreateProductRequest;
import com.utec.fullstack.backend.controller.request.Currency;
import com.utec.fullstack.backend.controller.request.Product;
import com.utec.fullstack.backend.controller.request.UpdateProductRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductMapping productMapping;

    private List<Product> products = new ArrayList<>() {{
        add(Product.builder()
                .id(1)
                .name("Pisco")
                .currency(Currency.SOL)
                .purchasePrice(20.0)
                .createdAt(LocalDateTime.now())
                .build());
        add(
                new Product(2, "Nombre", "IMAGE_URL", Currency.DOLLAR, 30.0, 50.0, 100.0, false, true, null, LocalDateTime.now(), LocalDateTime.now())
        );
    }};

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable("id") Integer id) {
        return this.products.get(id - 1);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@Valid @RequestBody CreateProductRequest product) {

        Product newProduct = this.productMapping.convert(product);
        newProduct.setCreatedAt(LocalDateTime.now());
        newProduct.setId(this.products.size() + 1);
        this.products.add(newProduct);
        return newProduct;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@PathVariable("id") Integer id,
                                 @RequestBody UpdateProductRequest product) {
        // UPDATE PRODUCTS SET name = :name where id = :id
        Product oldProductWithNewInfo = this.productMapping.convert(product);
        Product oldProduct = this.products.get(id - 1);

        Product updateProduct = this.productMapping.copyFrom(oldProduct, oldProductWithNewInfo);
        updateProduct.setUpdatedAt(LocalDateTime.now());

        this.products.set(id - 1, updateProduct);

        return updateProduct;
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
    public Boolean getStock(@PathVariable("id") String id, @PathVariable("stock") Double stock) {
        return stock < 20.0;
    }

}
