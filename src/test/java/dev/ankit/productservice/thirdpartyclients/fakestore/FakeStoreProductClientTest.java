package dev.ankit.productservice.thirdpartyclients.fakestore;

import dev.ankit.productservice.exceptions.NotFoundException;
import dev.ankit.productservice.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductClientTest {
    @Autowired
    private FakeStoreProductClient fakeStoreProductClient;

    @MockBean
    private RestTemplateBuilder restTemplateBuilder;

//    @MockBean
//    private RestTemplate restTemplate;

    @Test
    public void testGetProductById() throws NotFoundException {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        when(restTemplateBuilder.build())
                .thenReturn(restTemplate);

        ResponseEntity<FakeStoreProductDto> responseMock =
                new ResponseEntity<>(null, HttpStatus.OK);

        when(restTemplate.getForEntity(any(String.class), eq(FakeStoreProductDto.class), any(Long.class)))
                .thenReturn(responseMock);

        FakeStoreProductDto response = fakeStoreProductClient.getProductById(1L);

        Assertions.assertNull(response);

    }
}
