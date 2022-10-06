package btech.com.science.group.c.foeportal.course.services;

import btech.com.science.group.c.foeportal.course.entites.Course;
import btech.com.science.group.c.foeportal.course.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course creatCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Course course) {
        Optional<Course> optionalCourse = courseRepository.findAll()
                .stream().filter(course1 -> course1.getCourseId().equals(course.getCourseId()))
                .findFirst();

        if (optionalCourse.isPresent()) courseRepository.save(course);
        return course;
    }

    public Optional<Course> getCourseById(Long courseId){
        return courseRepository.findById(courseId);
    }

    public void deleteCourseById(Long courseId){
        courseRepository.deleteById(courseId);
    }
}
