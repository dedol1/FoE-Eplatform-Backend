package btech.com.science.group.c.foeportal.programs.controllers;

import btech.com.science.group.c.foeportal.programs.entites.Program;
import btech.com.science.group.c.foeportal.programs.services.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/program")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping
    public ResponseEntity<Program> createProgram(@RequestBody Program program){
        return new ResponseEntity<>(programService.createProgram(program), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Program>> getAllPrograms(){
        return new ResponseEntity<>(programService.getAllPrograms(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Program>> getProgramById(@PathVariable Long id){
        return new ResponseEntity<>(programService.findProgramById(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Program> updateProgram(@RequestBody Program program){
        return new ResponseEntity<>(programService.updateProgram(program),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgram(@PathVariable Long id){
        programService.deleteProgram(id);
        return new ResponseEntity<>(format("Program with id: %s deleted",id),HttpStatus.FOUND);
    }
}
