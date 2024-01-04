package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;

public interface ProductService {
    public GenericProductDto getProductById(Long id);

    public GenericProductDto createProduct(GenericProductDto genericProductDto);
}
