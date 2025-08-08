package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.courses WHERE s.studentId = :id")
    Optional<Student> findByIdWithCourses(@Param("id") Long id);

    @Query("SELECT DISTINCT s FROM Student s " +
            "LEFT JOIN FETCH s.courses " +
            "LEFT JOIN FETCH s.transcript " +
            "LEFT JOIN FETCH s.classroom")
    List<Student> findAllWithCoursesAndTranscriptAndClassroom();


//    @Query(value = "SELECT s FROM Student s JOIN FETCH s.transcript")
//    List<Student> findAllStudents();
//
//    @Query(value = """
//            """, nativeQuery = true)
//    List<Student> findAllStudentsAndTranscript();
//
//    List<Student> findStudentByFirstNameContaining(String firstName);
}
