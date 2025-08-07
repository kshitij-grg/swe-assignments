package edu.miu.cs.cs425.mystudentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Entity
@Table(name = "transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @Column(name = "degree_title", nullable = false, length = 128)
    private String degreeTitle;

    @OneToOne(mappedBy = "transcript")
    private Student student;

    public Transcript(Long transcriptId, String degreeTitle) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
