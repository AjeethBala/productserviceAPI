package dev.aji.productservice.inheritance_example.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "tpc_mentor")
public class Mentor extends User {
    private double avgRating;
}
