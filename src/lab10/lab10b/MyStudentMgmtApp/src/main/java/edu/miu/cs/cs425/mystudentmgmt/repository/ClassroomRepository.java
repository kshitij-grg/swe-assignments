package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}
