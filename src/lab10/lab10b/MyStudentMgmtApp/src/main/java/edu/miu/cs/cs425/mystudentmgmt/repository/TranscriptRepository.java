package edu.miu.cs.cs425.mystudentmgmt.repository;

import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
