package edu.miu.cs425.eregistrarwebapi.service;

import edu.miu.cs425.eregistrarwebapi.dto.student.StudentDTO;
import edu.miu.cs425.eregistrarwebapi.exception.StudentException;
import edu.miu.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO registerStudent(StudentDTO student);

    StudentDTO getStudentById(Integer id) throws StudentException;

    StudentDTO updateStudentById(Integer id, StudentDTO updatedStudentRequest) throws StudentException;

    void deleteStudentById(Integer id);
}
