package com.CS545.WAALAB2Restful.PhaseI.Repository;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courseList = new ArrayList<>();

    static {
        Course c1= new Course(1,"WAA","CS545");
        Course c2 = new Course(2, "EA","CS544");
        Course c3 = new Course(3,"CS490", "WAP");
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
    }

    public List<Course> findAll(){
        return courseList;
    }

    public Course findCourseById(int id){
        return courseList.stream().filter(s -> s.getId() == id).findFirst().get();
    }

}
