package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_code", nullable = false, length = 40)
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 50)
    private String courseName;
}
