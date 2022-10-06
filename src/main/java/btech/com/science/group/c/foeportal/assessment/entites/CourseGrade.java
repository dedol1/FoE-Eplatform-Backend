package btech.com.science.group.c.foeportal.accounts.entites;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class CourseGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String courseName;
    private String courseGrade;
    private Long courseMark;
    private Double courseGp;
}
