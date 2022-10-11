package btech.com.science.group.c.foeportal.students.controllers;

import btech.com.science.group.c.foeportal.course.entites.Course;
import btech.com.science.group.c.foeportal.course.services.CourseRegistrationService;
import btech.com.science.group.c.foeportal.students.entites.Student;
import btech.com.science.group.c.foeportal.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/student")
@PreAuthorize("hasRole('USER')")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserStudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @GetMapping("/info/{email}")
    public Student getStudentInfo(@PathVariable String email){
        Optional<Student> studentsByEmail = studentRepository.getStudentsByEmail(email);
        Student  student = null;
        if (studentsByEmail.isPresent()) student = studentsByEmail.get();
        return student;
    }

    @GetMapping("/courses/{programId}")
    public List<Course> getAvailableCourses(@PathVariable Long programId){
        return courseRegistrationService.getAllAvailableCourses(programId);
    }
}
