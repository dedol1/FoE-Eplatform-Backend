package btech.com.science.group.c.foeportal.students.repositories;

import btech.com.science.group.c.foeportal.students.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> getStudentsByEmail(String email);
}
