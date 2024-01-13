package dev.ankit.productservice.inheritanceexample.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_ta")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private String startTime;
    private String endTime;
}
