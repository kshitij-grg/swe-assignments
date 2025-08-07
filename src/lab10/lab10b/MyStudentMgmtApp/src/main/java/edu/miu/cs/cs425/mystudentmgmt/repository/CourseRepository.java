package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
