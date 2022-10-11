package btech.com.science.group.c.foeportal.departments.requests;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentRequest {

    private String departmentName;
    private List<Long> programIds;
}
