package edu.miu.cs425.eregistrarwebapi.dto.student;

import java.time.LocalDate;

public record StudentDTO(
        Integer studentId,
        String studentNumber,
        String firstName,
        String middleName,
        String lastName,
        Double cgpa,
        LocalDate dateOfEnrollment,
        boolean isInternational
) {
}
