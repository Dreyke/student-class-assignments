package com.dreyke.studentclassassignments.controller;

import javax.persistence.*;
import java.util.Date;

/* declares domain class as an entity/object we want to store in database */
@Entity
public class Course {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String instructor;
    private String assignment;
    private String description;
    private String dueDate;

    // empty constructor
    public Course() { }

    public Course(String name, String instructor, String assignment, String description, String dueDate) {
        this.name = name;
        this.instructor = instructor;
        this.assignment = assignment;
        this.description = description;
        this.dueDate = dueDate;
    }

    // variable get/setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
