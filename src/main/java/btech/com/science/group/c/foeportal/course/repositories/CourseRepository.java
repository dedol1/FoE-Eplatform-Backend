package btech.com.science.group.c.foeportal.course.repositories;

import btech.com.science.group.c.foeportal.course.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
