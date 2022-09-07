package com.CS545.WAALAB2Restful.PhaseI.Service;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Entity.Student;

import java.util.List;

public interface StudentService {
   List <Student> findAll();
   Student findStudentById(int id);
   Student update (Student student, int id);
   void delete (int id);
   Student create (Student student);
   List<Course> getCoursesByStudentId(int studentId);
   List<Student> getStudentsByMajor (String major);



}
