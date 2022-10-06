package btech.com.science.group.c.foeportal.departments.entites;

import btech.com.science.group.c.foeportal.programs.entites.Program;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private final String faculty = "FacultyOfEngineering";
    @OneToMany
    private List<Program> programs;
}
