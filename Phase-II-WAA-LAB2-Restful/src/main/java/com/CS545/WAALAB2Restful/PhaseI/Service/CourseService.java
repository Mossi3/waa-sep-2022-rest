package com.CS545.WAALAB2Restful.PhaseI.Service;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;

import java.util.List;

public interface CourseService {
    void delete (int id);
    List<Course> findAll();
    Course findCourseById(int id);
    Course create(Course course);
    Course update(Course course, int id);

}
