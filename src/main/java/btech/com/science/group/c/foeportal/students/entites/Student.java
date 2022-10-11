package btech.com.science.group.c.foeportal.students.entites;

import btech.com.science.group.c.foeportal.departments.entites.Department;
import btech.com.science.group.c.foeportal.programs.entites.Program;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String firstName;
    private String lastName;
    private Date DOB;
    @OneToOne
    private Program program;
    private int level = 100;
    private String indexNumber;
    @OneToOne
    private Department department;
    private String email;
    private String studentClass="Class A";
    private String status = "Active";
    private Boolean completedStatus = Boolean.FALSE;

}
