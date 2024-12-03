package com.project.p6.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "Professors")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    @Column(name = "professor_name", nullable = false, length = 100)
    private String professorName;

    @Column(name = "professor_contact", nullable = false, length = 100)
    private String professorContact;

    @Column(name = "office_hours", length = 100)
    private String officeHours;

    // Getters and Setters
    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getProfessorContact() {
        return professorContact;
    }

    public void setProfessorContact(String professorContact) {
        this.professorContact = professorContact;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}
