package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProduct(Long id);
}
