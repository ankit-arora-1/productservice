package dev.ankit.productservice.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductControllerTest {

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
}
