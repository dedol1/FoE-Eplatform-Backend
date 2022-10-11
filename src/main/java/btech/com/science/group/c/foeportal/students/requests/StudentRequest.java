package btech.com.science.group.c.foeportal.students.requests;

import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest {

    private String firstName;
    private String lastName;
    private Date DOB;
    private Long programId;
    private int level;
    private String indexNumber;
    private Long departmentId;
    private String email;
    private String studentClass;
}
