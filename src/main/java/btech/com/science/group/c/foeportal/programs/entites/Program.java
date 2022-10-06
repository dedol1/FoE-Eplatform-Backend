package btech.com.science.group.c.foeportal.programs.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long programId;
    private String programName;
    private int programDuration;
}
