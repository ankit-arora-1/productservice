package dev.ankit.productservice.controllers;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }


    public void updateProductById() {

    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }
}
