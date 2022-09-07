package com.CS545.WAALAB2Restful.PhaseI.Repository;

import com.CS545.WAALAB2Restful.PhaseI.Entity.Course;
import com.CS545.WAALAB2Restful.PhaseI.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

   private static  List<Student> studentList = new ArrayList<>();
//    private static List<Course> courseList = new ArrayList<>();
//    private static List <Course> courseList1 = new ArrayList<>();
    private static int currentId = 2;



    static{
        Course c1= new Course(1,"WAA","CS545");
        Course c2 = new Course(2, "EA","CS544");
        Course c3 = new Course(3,"CS490", "WAP");


        Student s1 = new Student(230,"Haile","Ghirmay","hailuwa@gmail.com","Compro", 3.99);
        s1.addCourse(c1);
        s1.addCourse(c2);
        s1.addCourse(c2);

        Student s2 = new Student (231, "Berhe", "Nayzghi", "berhino@gmail.com", "Compro", 3.8);
        s2.addCourse(c2);
        s2.addCourse(c3);



        studentList.add(s1);
        studentList.add(s2);

    }

//    public void add(Student student){
//        student.setId((currentId++));
//        studentList.add(student);
//    }

    public List<Student> findAll(){
        return studentList;
    }

    public List<Student> getStudentByMajor(String major) {
        return studentList.stream().filter(l-> l.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id) {
        var result = studentList.stream()
                .filter(l->l.getId() == id)
                .findFirst();

        return result.get().getCoursesTaken();
    }

    public Student findStudentById(int id){

//        students = studentRepo.findAll();
//        Student student = new Student();
//        for (Student s: students){
//            if(id == s.getId()){
//                student=s;
//            }
//        }
        return studentList.stream().filter(s -> s.getId() == id).findFirst().get();
    }






}
