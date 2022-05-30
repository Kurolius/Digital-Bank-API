package me.majbar.digitalbankingrestapi.dtos;


import lombok.Data;
import me.majbar.digitalbankingrestapi.enums.AccountStatus;

import java.util.Date;


@Data
public class SavingBankAccountDTO extends BankAccountDTO {

    private String id;

    private double balance;

    private Date createdAt;

    private CustomerDTO customer;

    private AccountStatus status;

    private double interestRate;

}
