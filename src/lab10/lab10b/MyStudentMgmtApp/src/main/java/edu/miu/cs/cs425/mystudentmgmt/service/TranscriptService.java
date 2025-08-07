package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Student;
import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmt.repository.TranscriptRepository;

import java.util.List;

public interface TranscriptService {
    List<Transcript> getAllTranscripts();
    Transcript saveTranscript(Transcript transcript);
}
