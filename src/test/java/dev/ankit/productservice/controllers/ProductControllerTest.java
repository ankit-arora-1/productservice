package dev.ankit.productservice.controllers;

import dev.ankit.productservice.dtos.GenericProductDto;
import dev.ankit.productservice.exceptions.NotFoundException;
import dev.ankit.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productServiceMock;

    @Test
    public void testGetProductById() {

    }

    @Test()
    public void testMathOperations() {
        int result = add(1,2);
//        assert(result == 3);

//        Assertions.assertEquals(4, result, "Some failure happened");
//
//        Integer result2 = add2(1,2);
//
//        Assertions.assertNull(result2);

//        Assertions.assertThrows(NullPointerException.class,
//                () -> call());

//        boolean flag = false;
//        try {
//            call();
//        } catch (Exception e) {
//            Assertions.assertEquals(0,0);
//            flag = true;
//        }
//
//        if(flag == false) {
//            Assertions.assertEquals(0,1);
//        }

        Assertions.assertThrows(NullPointerException.class, () -> doSomething());
    }

    private int add(int a, int b) {
        return a + b;
    }

    private Integer add2(int a, int b) {
        return null;
    }

    private void doSomething() {
        throw new NullPointerException();
    }


    @Test
    public void testGetProductByIdReturnsEmptyObjectWhenNoProductIsFound() throws NotFoundException {
        when(productServiceMock.getProductById(any(Long.class)))
                .thenReturn(null);

        GenericProductDto response = productController.getProductById(1L);

        Assertions.assertNotNull(response);
    }

    @Test
    public void testGetProductByIdReturnsCorrectResponse() throws NotFoundException {
        GenericProductDto toBeReturned = new GenericProductDto();
        toBeReturned.setId(1L);
        toBeReturned.setTitle("iPhone");

        when(productServiceMock.getProductById(any()))
                .thenReturn(toBeReturned);

        GenericProductDto response = productController.getProductById(1L);

        Assertions.assertEquals(response.getId(), 1L);
        Assertions.assertEquals(response.getTitle(), "iPhone");
    }

    @Test
    public void testGetProductById2() throws NotFoundException {
        when(productServiceMock.getProductById(any()))
                .thenReturn(null);

        GenericProductDto response = productController.getProductById(null);

        verify(productServiceMock, times(0)).getProductById(null);


    }

}
