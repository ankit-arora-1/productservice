package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("Calling from self product service");
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
