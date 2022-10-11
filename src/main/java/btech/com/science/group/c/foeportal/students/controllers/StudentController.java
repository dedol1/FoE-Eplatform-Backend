package btech.com.science.group.c.foeportal.students.controllers;

import btech.com.science.group.c.foeportal.students.entites.Student;
import btech.com.science.group.c.foeportal.students.requests.StudentRequest;
import btech.com.science.group.c.foeportal.students.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/student")
@PreAuthorize("hasRole('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest student){
        return new ResponseEntity<>(studentService.creatStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.updateStudent(student),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(format("Student with Id: %s deleted",id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.FOUND);
    }
}
