package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;
import dev.ankit.productservice.thirdpartyclients.fakestore.FakeStoreProductClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductServiceTest {

    @Autowired
    private FakeStoreProductService fakeStoreProductService;

    @MockBean
    private FakeStoreProductClient fakeStoreProductClient;

    @Test
    public void testGetProductByIdWhenClientReturnsNull() throws NotFoundException {
        when(fakeStoreProductClient.getProductById(any()))
                .thenReturn(null);

        GenericProductDto response = fakeStoreProductService.getProductById(1L);

        Assertions.assertNull(response);

        Assertions.assertThrows(NotFoundException.class,
                () -> fakeStoreProductService.getProductById(1L));
    }
}
