package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
