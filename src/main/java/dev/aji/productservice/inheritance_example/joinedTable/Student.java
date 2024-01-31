package dev.aji.productservice.inheritance_example.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_student")
@PrimaryKeyJoinColumn(name = "user_type")
public class Student extends User {
    private int psp;
    private String batch;

}
