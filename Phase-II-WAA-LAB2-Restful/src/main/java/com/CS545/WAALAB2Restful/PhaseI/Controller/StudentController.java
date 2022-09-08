package com.CS545.WAALAB2Restful.PhaseI.Controller;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Entity.Student;
import com.CS545.WAALAB2Restful.PhaseI.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){
        Student student = studentService.findStudentById(id);
        return ResponseEntity.ok(student);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int id){
        Student student1 = studentService.update(student, id);
        return ResponseEntity.ok(student1);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student student1 = studentService.create(student);
        return ResponseEntity.ok(student1);
    }

    @GetMapping(value = "/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable int id){
        List <Course> courses = studentService.getCoursesByStudentId(id);
        return ResponseEntity.ok().body(courses);
    }


    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudentsByMajor(@RequestParam String major){
        var students = studentService.getStudentsByMajor(major);
        return ResponseEntity.ok().body(students);
    }
}
