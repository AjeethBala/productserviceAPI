package dev.aji.productservice.inheritance_example.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name = "jt_TA")
@PrimaryKeyJoinColumn(name ="user_type")
public class TA extends User {
    private String startTime;
    private String endTime;
}
