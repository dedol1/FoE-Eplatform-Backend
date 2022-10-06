package btech.com.science.group.c.foeportal.departments.repositories;

import btech.com.science.group.c.foeportal.departments.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
