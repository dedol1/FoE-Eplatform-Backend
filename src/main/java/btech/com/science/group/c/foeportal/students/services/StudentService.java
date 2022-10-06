package btech.com.science.group.c.foeportal.students.services;

import btech.com.science.group.c.foeportal.students.entites.Student;
import btech.com.science.group.c.foeportal.students.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student creatStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        Optional<Student> optionalCourse = studentRepository.findAll()
                .stream().filter(record -> record.getStudentId().equals(student.getStudentId()))
                .findFirst();

        if (optionalCourse.isPresent()) studentRepository.save(student);
        return student;
    }

    public Optional<Student> getStudentById(Long recordId){
        return studentRepository.findById(recordId);
    }

    public void deleteStudentById(Long accountId){
        studentRepository.deleteById(accountId);
    }


}
