package btech.com.science.group.c.foeportal.departments.services;

import btech.com.science.group.c.foeportal.departments.entites.Department;
import btech.com.science.group.c.foeportal.departments.repositories.DepartmentRepository;
import btech.com.science.group.c.foeportal.departments.requests.DepartmentRequest;
import btech.com.science.group.c.foeportal.programs.entites.Program;
import btech.com.science.group.c.foeportal.programs.services.ProgramService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ProgramService programService;

    public DepartmentService(DepartmentRepository departmentRepository, ProgramService programService) {
        this.departmentRepository = departmentRepository;
        this.programService = programService;
    }

    public Department createDepartment(DepartmentRequest department) {
        Department department1 = new Department();
        department1.setDepartmentName(department.getDepartmentName());
        department1.setPrograms(getProgramsById(department.getProgramIds()));
        return departmentRepository.save(department1);
    }

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long departmentId, DepartmentRequest request){
        Optional<Department> department = getAllDepartment().stream()
                .filter(d -> d.getDepartmentId().equals(departmentId)).findFirst();
        if (department.isPresent()){
            Department department1 = department.get();
            department1.setDepartmentName(request.getDepartmentName());
            department1.setPrograms(getProgramsById(request.getProgramIds()));
            departmentRepository.save(department1);
        }
        return department.get();
    }

    public List<Program> getProgramsById(List<Long> ids){
        List<Program> programs = new ArrayList<>();
        ids.forEach(programId -> {
            Optional<Program> program = programService.findProgramById(programId);
            program.ifPresent(programs::add);
        });
        return programs;
    }

    public Optional<Department> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}
