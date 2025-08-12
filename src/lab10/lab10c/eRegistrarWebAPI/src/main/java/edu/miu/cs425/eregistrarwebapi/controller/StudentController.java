package edu.miu.cs425.eregistrarwebapi.controller;

import edu.miu.cs425.eregistrarwebapi.dto.student.StudentDTO;
import edu.miu.cs425.eregistrarwebapi.exception.StudentException;
import edu.miu.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs425.eregistrarwebapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/eregistrar/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping(value = "/register")
    public ResponseEntity<StudentDTO> registerStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.registerStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) throws StudentException {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id, @Valid @RequestBody StudentDTO dto) throws StudentException {
        return ResponseEntity.ok(studentService.updateStudentById(id, dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) throws StudentException {
        studentService.getStudentById(id); // Will throw if not found
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student with ID " + id + " has been deleted successfully.");
    }
}
