package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "student_number", length = 45, unique = true,  nullable = false)
    private String studentNumber;

    @Column(name = "first_name", length = 60, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 60)
    private String middleName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(name = "cgpa")
    private Double cgpa;

    @Column(name = "date_of_enrollment", nullable = false)
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "transcript_id", nullable = true)
    private Transcript transcript;

//    @OneToMany
//    @JoinColumn(name = "classroom")
//    private Classroom classroom;
}
