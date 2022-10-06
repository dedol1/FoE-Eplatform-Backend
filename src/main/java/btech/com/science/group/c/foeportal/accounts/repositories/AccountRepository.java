package btech.com.science.group.c.foeportal.accounts.repositories;

import btech.com.science.group.c.foeportal.accounts.entites.Account;
import btech.com.science.group.c.foeportal.programs.entites.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
