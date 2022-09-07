package com.CS545.WAALAB2Restful.PhaseI.Service.Impl;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Entity.Student;
import com.CS545.WAALAB2Restful.PhaseI.Repository.StudentRepo;
import com.CS545.WAALAB2Restful.PhaseI.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;
    List<Student> students = new ArrayList<>();

    @Override
    public List <Student> findAll(){
        return studentRepo.findAll();
    }

    @Override
    public Student findStudentById(int id){
        Student student = studentRepo.findStudentById(id);
//        students = studentRepo.findAll();
//        Student student = new Student();
//        for (Student s: students){
//            if(id == s.getId()){
//                student=s;
//            }
//        }
        return student;
    }

    @Override
    public Student update (Student student, int id){
//        students = studentRepo.findAll();
//        var student1 = students.stream().filter(s -> s.getId()==id).findFirst();
//        if(student1.isPresent()){
//            students.remove(student1.get());
//            students.add(student);
//        }
        Student student1 = studentRepo.findStudentById(id);
        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setGpa(student.getGpa());
        student1.setCoursesTaken(student.getCoursesTaken());

        students.add(student1);

        return student1;

    }
   @Override
   public void delete (int id){
        Student student = studentRepo.findStudentById(id);
        students.remove(student);
    }

    @Override
    public Student create (Student student){
        Student student1 = new Student();

        student1.setId(student.getId());
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setMajor(student.getMajor());
        student1.setGpa(student.getGpa());
        student1.setCoursesTaken(student.getCoursesTaken());
        students.add(student1);
        return student1;
    }

    @Override
    public List<Course> getCoursesByStudentId(int id){
        List <Course> courses = studentRepo.getCoursesByStudentId(id);
        return courses;
    }

    @Override
   public  List<Student> getStudentsByMajor (String major){
        List <Student> slist = studentRepo.getStudentByMajor(major);

        return slist;

    }

}
