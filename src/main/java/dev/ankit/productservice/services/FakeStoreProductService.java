package dev.ankit.productservice.services;

import dev.ankit.productservice.thirdpartyclients.fakestore.FakeStoreProductClient;
import dev.ankit.productservice.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private FakeStoreProductClient fakeStoreProductClient;

    private RedisTemplate<String, Object> redisTemplate;
    private RestTemplate restTemplate;


    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient,
                                   RedisTemplate<String, Object> redisTemplate,
                                   RestTemplate restTemplate) {
        this.fakeStoreProductClient = fakeStoreProductClient;
        this.redisTemplate = redisTemplate;
        this.restTemplate = restTemplate;
    }

    public GenericProductDto convertFakeStoreDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        if(fakeStoreProductDto == null) {
            return null;
        }

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
        Object userData = restTemplate.getForEntity("http://userservice/users/1",
                Object.class);


        GenericProductDto genericProductDtoFromCache =
                (GenericProductDto) redisTemplate.opsForValue().get(String.valueOf(id));

        if(genericProductDtoFromCache != null) {
            return genericProductDtoFromCache;
        }

        System.out.println("Printing from FakeStoreProductService");
        GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(
                fakeStoreProductClient.getProductById(id)
        );

        redisTemplate.opsForValue().set(String.valueOf(id), genericProductDto);
        return genericProductDto;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {

        return convertFakeStoreDtoToGenericProductDto(
                fakeStoreProductClient.createProduct(product)
        );
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos =
                fakeStoreProductClient.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
            GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);

            genericProductDtos.add(genericProductDto);
        }

        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakeStoreDtoToGenericProductDto(
                fakeStoreProductClient.deleteProduct(id)
        );
    }
}
