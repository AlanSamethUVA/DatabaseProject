package com.project.p6.persistance;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private String semester;

}
