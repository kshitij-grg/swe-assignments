package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import edu.miu.cs.cs425.mystudentmgmt.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional()
    @Override
    public List<Student> getAllStudentsWithAllDetails() {
//        return studentRepository.findAllStudents()
        return studentRepository.findAllWithCoursesAndTranscriptAndClassroom()
                .stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .toList();
    }

    @Transactional()
    public void printAllStudentsWithDetails() {
        List<Student> students = studentRepository.findAllWithCoursesAndTranscriptAndClassroom();

        for (Student s : students) {
            String details = "Student{studentId=" + s.getStudentId() +
                    ", studentNumber='" + s.getStudentNumber() +
                    ", name=" + s.getFirstName() + " " + s.getMiddleName() + " " + s.getLastName() +
                    ", dateOfEnrollment=" + s.getDateOfEnrollment() +
                    ", cgpa=" + s.getCgpa() +
                    ", transcript=" + (s.getTranscript() != null ? s.getTranscript().getDegreeTitle() : "N/A") +
                    ", classroom=" + (s.getClassroom() != null ? s.getClassroom().getBuildingName() + " " + s.getClassroom().getRoomNumber() : "N/A") +
                    ", courses=" + s.getCourses().stream()
                    .map(c -> c.getCourseCode() + ": " + c.getCourseName())
                    .collect(Collectors.joining(", ")) +
                    "}";

            System.out.println(details);
        }
    }

    @Transactional()
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Student getStudentByIdWithCourses(Long id) {
        return studentRepository.findByIdWithCourses(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
    }

}
