package edu.miu.cs425.eregistrarwebapi.service.impl;

import edu.miu.cs425.eregistrarwebapi.dto.student.StudentDTO;
import edu.miu.cs425.eregistrarwebapi.exception.StudentException;
import edu.miu.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs425.eregistrarwebapi.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(
                        student -> new StudentDTO(
                                student.getStudentId(),
                                student.getStudentNumber(),
                                student.getFirstName(),
                                student.getMiddleName(),
                                student.getLastName(),
                                student.getCgpa(),
                                student.getDateOfEnrollment(),
                                student.isInternational()
                        )
                )
                .sorted(Comparator.comparing(StudentDTO::firstName))
                .toList();
    }

    @Override
    public StudentDTO registerStudent(StudentDTO newStudentRequest) {
        var newStudent = new Student(null, newStudentRequest.studentNumber(), newStudentRequest.firstName(),
                newStudentRequest.middleName(), newStudentRequest.lastName(), newStudentRequest.cgpa(),
                newStudentRequest.dateOfEnrollment(), newStudentRequest.isInternational()
        );
        var savedStudent = studentRepository.save(newStudent);

        return new StudentDTO(
                savedStudent.getStudentId(),
                savedStudent.getStudentNumber(),
                savedStudent.getFirstName(),
                savedStudent.getMiddleName(),
                savedStudent.getLastName(),
                savedStudent.getCgpa(),
                savedStudent.getDateOfEnrollment(),
                savedStudent.isInternational()
        );
    }

    @Override
    public StudentDTO getStudentById(Integer id) throws StudentException {
        var student = studentRepository.findById(id).orElseThrow(() ->
                new StudentException(
                        String.format("Student with ID, %s not found", id)
                )
        );
        return new StudentDTO(
                student.getStudentId(),
                student.getStudentNumber(),
                student.getFirstName(),
                student.getMiddleName(),
                student.getLastName(),
                student.getCgpa(),
                student.getDateOfEnrollment(),
                student.isInternational()
        );
    }

    @Override
    public StudentDTO updateStudentById(Integer id, StudentDTO updatedStudentRequest) throws StudentException{

        var existingStudent = studentRepository.findById(id).orElseThrow(() ->
                new StudentException(
                        String.format("Student with ID, %s not found", id)
                )
        );

        existingStudent.setStudentNumber(updatedStudentRequest.studentNumber());
        existingStudent.setFirstName(updatedStudentRequest.firstName());
        existingStudent.setMiddleName(updatedStudentRequest.middleName());
        existingStudent.setLastName(updatedStudentRequest.lastName());
        existingStudent.setCgpa(updatedStudentRequest.cgpa());
        existingStudent.setDateOfEnrollment(updatedStudentRequest.dateOfEnrollment());
        existingStudent.setInternational(updatedStudentRequest.isInternational());

        var savedStudent = studentRepository.save(existingStudent);

        return new StudentDTO(
                savedStudent.getStudentId(),
                savedStudent.getStudentNumber(),
                savedStudent.getFirstName(),
                savedStudent.getMiddleName(),
                savedStudent.getLastName(),
                savedStudent.getCgpa(),
                savedStudent.getDateOfEnrollment(),
                savedStudent.isInternational()
        );
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}