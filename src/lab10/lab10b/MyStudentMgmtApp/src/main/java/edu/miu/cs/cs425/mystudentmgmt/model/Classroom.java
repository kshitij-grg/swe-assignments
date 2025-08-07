package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;

    @Column(name = "building_name",nullable = false, length = 128)
    private String buildingName;

    @Column(name = "room_number", nullable = false, length = 40)
    private String roomNumber;

//    @OneToMany(mappedBy = "classroom")
//    private Student student;
}
