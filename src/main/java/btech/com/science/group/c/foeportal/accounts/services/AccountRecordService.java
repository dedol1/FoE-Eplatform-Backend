package btech.com.science.group.c.foeportal.accounts.services;

import btech.com.science.group.c.foeportal.accounts.entites.AccountRecord;
import btech.com.science.group.c.foeportal.accounts.repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountRecordService {

    private final RecordRepository recordRepository;

    public AccountRecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public AccountRecord creatAccountRecord(AccountRecord record) {
        return recordRepository.save(record);
    }

    public List<AccountRecord> getAllAccountRecord() {
        return recordRepository.findAll();
    }

    public AccountRecord updateAccountRecord(AccountRecord accountRecord) {
        Optional<AccountRecord> optionalCourse = recordRepository.findAll()
                .stream().filter(record -> record.getRecordId().equals(accountRecord.getRecordId()))
                .findFirst();

        if (optionalCourse.isPresent()) recordRepository.save(accountRecord);
        return accountRecord;
    }

    public Optional<AccountRecord> getAccountRecordById(Long recordId){
        return recordRepository.findById(recordId);
    }

    public void deleteAccountRecordById(Long courseId){
        recordRepository.deleteById(courseId);
    }
}
