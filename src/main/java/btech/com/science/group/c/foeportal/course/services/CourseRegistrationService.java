package btech.com.science.group.c.foeportal.course.services;

import btech.com.science.group.c.foeportal.course.entites.Course;
import btech.com.science.group.c.foeportal.course.entites.RegisteredCourses;
import btech.com.science.group.c.foeportal.course.repositories.CourseRepository;
import btech.com.science.group.c.foeportal.course.repositories.RegisteredCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private RegisteredCoursesRepository registeredCoursesRepository;

    public List<Course> getAllAvailableCourses(Long programId){
        return courseRepository.findCourseByProgramId(programId);
    }

    public String registerCourses(RegisteredCourses registeredCourses){
        registeredCoursesRepository.save(registeredCourses);

        return "course registered successfully";
    }
}
