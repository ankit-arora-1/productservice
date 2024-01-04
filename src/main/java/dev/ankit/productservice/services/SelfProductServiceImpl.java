package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    @Override
    public GenericProductDto getProductById(Long id) {
        System.out.println("Calling from self product service");
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }
}
