package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
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

    // One classroom has many students
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", classroomId=" + classroomId +
                '}';
    }
}
