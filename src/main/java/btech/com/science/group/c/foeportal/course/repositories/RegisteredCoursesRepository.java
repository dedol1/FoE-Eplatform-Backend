package btech.com.science.group.c.foeportal.course.repositories;

import btech.com.science.group.c.foeportal.course.entites.RegisteredCourses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredCoursesRepository extends JpaRepository<RegisteredCourses, Long> {
}
