package btech.com.science.group.c.foeportal.programs.repositories;

import btech.com.science.group.c.foeportal.programs.entites.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
}
