package btech.com.science.group.c.foeportal.course.controllers;

import btech.com.science.group.c.foeportal.course.entites.Course;
import btech.com.science.group.c.foeportal.course.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/course")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.creatCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.updateCourse(course),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return new ResponseEntity<>(format("Course with Id: %s deleted",id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseService.getCourseById(id),HttpStatus.FOUND);
    }
}
