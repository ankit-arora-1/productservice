package dev.ankit.productservice.inheritanceexample.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private double avgRating;
}
