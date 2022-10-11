package btech.com.science.group.c.foeportal.course.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RegisteredCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    @ManyToMany
    List<Course> courses;
    private Long studentId;
}
