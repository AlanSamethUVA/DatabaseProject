package com.project.p6.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private long department; //FOREIGN KEY

    private String name;
    private String semester;
    private long professor;


}
