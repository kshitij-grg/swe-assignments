package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudentsWithAllDetails();
    Student saveStudent(Student student);
    Student getStudentById(int id);
    Student updateStudent(Student student);
    void deleteStudentById(int id);
    Student getStudentByIdWithCourses(Long id);
    void printAllStudentsWithDetails();
}
