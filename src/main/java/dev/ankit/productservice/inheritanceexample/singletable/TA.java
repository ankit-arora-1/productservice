package dev.ankit.productservice.inheritanceexample.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
@DiscriminatorValue(value = "3")
public class TA extends User {
    private String startTime;
    private String endTime;
}
