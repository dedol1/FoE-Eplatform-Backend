package btech.com.science.group.c.foeportal.students.repositories;

import btech.com.science.group.c.foeportal.students.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
