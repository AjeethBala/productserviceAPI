package dev.aji.productservice.inheritance_example.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "msc_TA")
public class TA extends User {
    private String startTime;
    private String endTime;
}
