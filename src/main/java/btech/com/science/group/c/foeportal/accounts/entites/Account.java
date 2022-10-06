package btech.com.science.group.c.foeportal.accounts.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private Double accountBalance;
    @OneToMany
    private List<AccountRecord> records;
}
