package btech.com.science.group.c.foeportal.assessment.repositories;

import btech.com.science.group.c.foeportal.assessment.entites.Assessment;
import btech.com.science.group.c.foeportal.programs.entites.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
