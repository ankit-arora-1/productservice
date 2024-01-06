package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.FakeStoreProductDto;
import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private String productUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestUrl = "https://fakestoreapi.com/products/";
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto convertFakeStoreDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                productUrl,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: " + id + " not found");
        }

        GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);


        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .postForEntity(
                        productRequestUrl,
                        product,
                        FakeStoreProductDto.class);


        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);

        return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate
                .getForEntity(productRequestUrl, FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
            GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);

            genericProductDtos.add(genericProductDto);
        }

        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> response = restTemplate
                .exchange(productUrl, HttpMethod.DELETE, null, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);

        return genericProductDto;
    }
}
