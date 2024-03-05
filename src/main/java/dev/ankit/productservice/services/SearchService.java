package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<GenericProductDto> search(String query, int pageSize, int pageNumber) {

        Sort sort = Sort.by("title").ascending()
                .and(Sort.by("inventory_count").descending())
                .and(Sort.by("abc")).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);


        Page<Product> productPage = productRepository
                .findAllByTitleContaining(query, pageable);

        List<Product> products = productPage.get().toList();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(Product product: products) {
            genericProductDtos.add(mapProductToGenericProduct(product));
        }

        Page<GenericProductDto> genericProductDtoPage =
                new PageImpl<GenericProductDto>(genericProductDtos,
                        productPage.getPageable(), productPage.getTotalElements());

        return genericProductDtoPage;
    }

    public GenericProductDto mapProductToGenericProduct(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setDescription(product.getDescription());

        return genericProductDto;
    }
}
