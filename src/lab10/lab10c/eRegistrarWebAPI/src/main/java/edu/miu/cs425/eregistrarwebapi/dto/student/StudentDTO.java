package edu.miu.cs425.eregistrarwebapi.dto.student;

import java.time.LocalDate;
import java.util.Set;

public record StudentResponseDTO(Long studentId,
                                 String studentNumber,
                                 String firstName,
                                 String middleName,
                                 String lastName,
                                 Double cgpa,
                                 LocalDate dateOfEnrollment,
                                 boolean isInternational
                                 )  {
}
