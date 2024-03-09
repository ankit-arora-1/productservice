package dev.ankit.productservice.dtos;

import dev.ankit.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenericProductDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
