package btech.com.science.group.c.foeportal.students.services;

import btech.com.science.group.c.foeportal.departments.entites.Department;
import btech.com.science.group.c.foeportal.departments.repositories.DepartmentRepository;
import btech.com.science.group.c.foeportal.programs.entites.Program;
import btech.com.science.group.c.foeportal.programs.repositories.ProgramRepository;
import btech.com.science.group.c.foeportal.security.springjwt.models.ERole;
import btech.com.science.group.c.foeportal.security.springjwt.models.Role;
import btech.com.science.group.c.foeportal.security.springjwt.models.User;
import btech.com.science.group.c.foeportal.security.springjwt.repository.RoleRepository;
import btech.com.science.group.c.foeportal.security.springjwt.repository.UserRepository;
import btech.com.science.group.c.foeportal.students.entites.Student;
import btech.com.science.group.c.foeportal.students.repositories.StudentRepository;
import btech.com.science.group.c.foeportal.students.requests.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ProgramRepository programRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student creatStudent(StudentRequest student) {
        User user = new User(student.getEmail(),
                student.getEmail(),
                encoder.encode("Pass@123"));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);

        Student newStudent = new Student();
        Optional<Department> dept = departmentRepository.findById(student.getDepartmentId());
        dept.ifPresent(newStudent::setDepartment);

        Optional<Program> prog = programRepository.findById(student.getProgramId());
        prog.ifPresent(newStudent::setProgram);

        newStudent.setEmail(student.getEmail());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setLevel(student.getLevel());
        return studentRepository.save(newStudent);
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
