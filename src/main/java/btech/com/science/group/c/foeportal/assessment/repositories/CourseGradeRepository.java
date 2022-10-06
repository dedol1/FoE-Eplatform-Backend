package btech.com.science.group.c.foeportal.assessment.repositories;

import btech.com.science.group.c.foeportal.accounts.entites.CourseGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseGradeRepository extends JpaRepository<CourseGrade, Long> {
}
