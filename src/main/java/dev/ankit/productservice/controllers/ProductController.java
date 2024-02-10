package dev.ankit.productservice.controllers;

import dev.ankit.productservice.dtos.ExceptionDto;
import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.security.JwtData;
import dev.ankit.productservice.security.TokenValidator;
import dev.ankit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private TokenValidator tokenValidator;

    @Autowired
    public ProductController(ProductService productService, TokenValidator tokenValidator) {
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,
            @PathVariable("id") Long id) throws NotFoundException {
        System.out.println("Calling methods");
        System.out.println("Calling methods again");

        Optional<JwtData> jwtDataOptional = tokenValidator.validateToken(authToken);
        if(jwtDataOptional.isPresent()) {
            // Do whatever needs to be done according to the business logic
        }


        GenericProductDto genericProductDto = productService.getProductById(id);
        if(genericProductDto == null) {
            return new GenericProductDto();
        }

        return genericProductDto;
    }


    public void updateProductById() {

    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        // return productService.deleteProduct(id);
    }

    // This is specific to this controller
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException) {
//        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND);
//    }

}
