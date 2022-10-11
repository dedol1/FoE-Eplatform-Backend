package btech.com.science.group.c.foeportal.security.springjwt.repository;


import btech.com.science.group.c.foeportal.security.springjwt.models.ERole;
import btech.com.science.group.c.foeportal.security.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
