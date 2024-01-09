package dev.ankit.productservice.thirdpartyclients.fakestore.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}
