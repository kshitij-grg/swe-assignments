package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmt.repository.TranscriptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    private final TranscriptRepository transcriptRepository;
    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public List<Transcript> getAllTranscripts() {
        return transcriptRepository.findAll();
    }

    @Override
    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
}
