package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "student_number", length = 45, unique = true,  nullable = false)
//    @NotNull(message = "Student Number cannot be null")
    @NotEmpty(message = "Student Number cannot be null or an empty string")
    private String studentNumber;

//    @Email(message = "Must be a valid email address")
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
    @JoinColumn(name = "transcript_id")
    private Transcript transcript;

    // Many students belong to one classroom
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @ManyToMany
    @JoinTable(
            name = "student_course", // Join table
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"), // FK to Student
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"), // FK to Course
            uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "course_id"})
    )
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "dateOfEnrollment=" + dateOfEnrollment +
                ", cgpa=" + cgpa +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentId=" + studentId +
                '}';
    }
}
