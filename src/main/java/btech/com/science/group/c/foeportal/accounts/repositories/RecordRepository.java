package btech.com.science.group.c.foeportal.accounts.repositories;

import btech.com.science.group.c.foeportal.accounts.entites.AccountRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<AccountRecord, Long> {
}


