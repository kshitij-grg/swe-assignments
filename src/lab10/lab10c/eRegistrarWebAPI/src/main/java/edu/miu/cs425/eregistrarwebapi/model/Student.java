package edu.miu.cs425.eregistrarwebapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "student_number", length = 45, unique = true, nullable = false)
    @NotEmpty(message = "Student Number cannot be null or an empty string")
    private String studentNumber;

    @NotEmpty(message = "First Name is required")
    @Column(name = "first_name", length = 60, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 60)
    private String middleName;

    @NotEmpty(message = "Last Name is required")
    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(name = "cgpa")
    private Double cgpa;

    @NotEmpty(message = "Enrollment Date is required")
    @Column(name = "date_of_enrollment", nullable = false)
    private LocalDate dateOfEnrollment;

    @NotEmpty(message = "isInternational must be 'Yes' or 'No'")
    @Pattern(regexp = "Yes|No", message = "isInternational must be 'Yes' or 'No'")
    @Column(name = "isInternational", nullable = false)
    private boolean isInternational;
}
