package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.FakeStoreProductDto;
import dev.ankit.productservice.dtos.GenericProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String productUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductUrl = "https://fakestoreapi.com/products/";
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                productUrl,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .postForEntity(
                        createProductUrl,
                        product,
                        FakeStoreProductDto.class);


        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return genericProductDto;
    }
}
