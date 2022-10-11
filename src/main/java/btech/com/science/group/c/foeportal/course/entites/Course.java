package btech.com.science.group.c.foeportal.course.entites;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;
    private String courseCode;
    private int creditHours;
    private Long programId;

}
