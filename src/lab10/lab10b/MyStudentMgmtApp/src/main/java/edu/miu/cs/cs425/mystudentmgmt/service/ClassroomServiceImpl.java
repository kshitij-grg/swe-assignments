package edu.miu.cs.cs425.mystudentmgmt.service;

import edu.miu.cs.cs425.mystudentmgmt.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmt.repository.ClassroomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Transactional()
    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }
}
