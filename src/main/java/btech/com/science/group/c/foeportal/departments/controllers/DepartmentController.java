package btech.com.science.group.c.foeportal.departments.controllers;

import btech.com.science.group.c.foeportal.departments.entites.Department;
import btech.com.science.group.c.foeportal.departments.requests.DepartmentRequest;
import btech.com.science.group.c.foeportal.departments.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/department")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequest departmentRequest){
        return new ResponseEntity<>(departmentService.createDepartment(departmentRequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@RequestBody DepartmentRequest departmentRequest,@PathVariable Long id){
        return new ResponseEntity<>(departmentService.updateDepartment(id,departmentRequest),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(format("Department with Id: %s deleted",id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.getDepartmentById(id),HttpStatus.FOUND);
    }
}
