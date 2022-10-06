package btech.com.science.group.c.foeportal.accounts.services;

import btech.com.science.group.c.foeportal.accounts.entites.Account;
import btech.com.science.group.c.foeportal.accounts.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account creatAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account updateAccount(Account account) {
        Optional<Account> optionalCourse = accountRepository.findAll()
                .stream().filter(record -> record.getAccountId().equals(account.getAccountId()))
                .findFirst();

        if (optionalCourse.isPresent()) accountRepository.save(account);
        return account;
    }

    public Optional<Account> getAccountById(Long recordId){
        return accountRepository.findById(recordId);
    }

    public void deleteAccountById(Long accountId){
        accountRepository.deleteById(accountId);
    }
}
