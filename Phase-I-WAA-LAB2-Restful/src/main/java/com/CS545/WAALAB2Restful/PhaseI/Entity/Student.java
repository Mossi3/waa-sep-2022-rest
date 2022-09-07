package com.CS545.WAALAB2Restful.PhaseI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private double gpa;
    private List<Course> coursesTaken;

    public Student(int id, String firstName, String lastName, String email, String major, double gpa){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.coursesTaken = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.coursesTaken.add(course);
    }
}
