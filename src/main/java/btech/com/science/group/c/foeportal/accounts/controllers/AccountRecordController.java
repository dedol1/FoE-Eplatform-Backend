package btech.com.science.group.c.foeportal.accounts.controllers;

import btech.com.science.group.c.foeportal.accounts.entites.AccountRecord;
import btech.com.science.group.c.foeportal.accounts.services.AccountRecordService;
import btech.com.science.group.c.foeportal.course.entites.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/accountRecord")
public class AccountRecordController {

    private final AccountRecordService accountRecordService;
    
    public AccountRecordController(AccountRecordService accountRecordService) {
        this.accountRecordService = accountRecordService;
    }

    @PostMapping
    public ResponseEntity<AccountRecord> createCourse(@RequestBody AccountRecord accountRecord){
        return new ResponseEntity<>(accountRecordService.creatAccountRecord(accountRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountRecord>> getAllCourses(){
        return new ResponseEntity<>(accountRecordService.getAllAccountRecord(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AccountRecord> updateCourse(@RequestBody AccountRecord accountRecord){
        return new ResponseEntity<>(accountRecordService.updateAccountRecord(accountRecord),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id){
        accountRecordService.deleteAccountRecordById(id);
        return new ResponseEntity<>(format("Course with Id: %s deleted",id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AccountRecord>> getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(accountRecordService.getAccountRecordById(id),HttpStatus.FOUND);
    }
}
