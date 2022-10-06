package btech.com.science.group.c.foeportal.programs.services;

import btech.com.science.group.c.foeportal.programs.entites.Program;
import btech.com.science.group.c.foeportal.programs.repositories.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public Program createProgram(Program program){
        return programRepository.save(program);
    }

    public List<Program> getAllPrograms(){
        return programRepository.findAll();
    }

    public Program updateProgram(Program program){
        Optional<Program> programToUpdate = getAllPrograms().stream()
                .filter(p -> p.getProgramId().equals(program.getProgramId())).findFirst();
        programToUpdate.ifPresent(program1 -> {
            program1.setProgramName(program.getProgramName());
            program1.setProgramDuration(program.getProgramDuration());
            programRepository.save(program1);
        });
        return program;
    }

    public void deleteProgram(Long programId){
        programRepository.deleteById(programId);
    }

    public Optional<Program> findProgramById(Long programId){
        return programRepository.findById(programId);
    }
}
