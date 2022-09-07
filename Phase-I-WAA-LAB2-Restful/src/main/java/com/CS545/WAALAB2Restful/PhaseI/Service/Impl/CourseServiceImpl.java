package com.CS545.WAALAB2Restful.PhaseI.Service.Impl;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Repository.CourseRepo;
import com.CS545.WAALAB2Restful.PhaseI.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;
    List <Course> courses = new ArrayList<>();

    @Override
   public List<Course> findAll(){
        return courseRepo.findAll();
    }


    @Override
    public Course findCourseById(int id){
        return courseRepo.findCourseById(id);
    }


    public void delete (int id){
        Course course = courseRepo.findCourseById(id);
        courses.remove(course);

    }

    @Override
    public Course create(Course course){
        Course course1 = new Course();
        course1.setId(course.getId());
        course1.setName(course.getName());
        course1.setCode(course.getCode());

        courses.add(course1);
        return course1;
    }

    @Override
    public Course update(Course course, int id){
        Course course1 = courseRepo.findCourseById(id);

        course1.setId(course.getId());
        course1.setName(course.getName());
        course1.setCode(course.getCode());

        courses.add(course1);
        return course1;
    }
}
