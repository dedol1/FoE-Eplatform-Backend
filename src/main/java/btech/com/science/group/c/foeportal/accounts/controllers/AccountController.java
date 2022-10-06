package btech.com.science.group.c.foeportal.accounts.controllers;

import btech.com.science.group.c.foeportal.accounts.entites.Account;
import btech.com.science.group.c.foeportal.accounts.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createCourse(@RequestBody Account account){
        return new ResponseEntity<>(accountService.creatAccount(account), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllCourses(){
        return new ResponseEntity<>(accountService.getAllAccount(),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Account> updateCourse(@RequestBody Account accountRecord){
        return new ResponseEntity<>(accountService.updateAccount(accountRecord),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(format("Course with Id: %s deleted",id),HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> getCourseById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.FOUND);
    }
}
