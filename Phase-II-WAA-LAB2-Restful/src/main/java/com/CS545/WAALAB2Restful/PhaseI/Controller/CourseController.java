package com.CS545.WAALAB2Restful.PhaseI.Controller;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public ResponseEntity<List<Course>> findAll(){
        List<Course> courses = courseService.findAll();
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable  int id){
        Course course = courseService.findCourseById(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        Course course1 = courseService.create(course);
        return ResponseEntity.ok(course1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable int id){
        Course course1 = courseService.update(course,id);
        return ResponseEntity.ok(course1);
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> delete(@PathVariable int id){
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
