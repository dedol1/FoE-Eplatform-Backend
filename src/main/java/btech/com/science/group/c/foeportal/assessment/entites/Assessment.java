package btech.com.science.group.c.foeportal.assessment.entites;

import btech.com.science.group.c.foeportal.accounts.entites.CourseGrade;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String assessmentName;
    @OneToMany
    private List<CourseGrade> courseGrades;
}
