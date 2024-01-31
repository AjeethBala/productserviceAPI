package dev.aji.productservice.inheritance_example.mappedSuperClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_student")
public class Student extends User {
    private int psp;
    private String batch;

}
