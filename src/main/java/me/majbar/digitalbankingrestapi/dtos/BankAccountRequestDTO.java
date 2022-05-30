package me.majbar.digitalbankingrestapi.dtos;


import lombok.Data;
import me.majbar.digitalbankingrestapi.enums.AccountStatus;

import java.util.Date;


@Data
public class BankAccountRequestDTO  {

    private String id;

    private double balance;

    private Date createdAt;

    private CustomerDTO customer;


    private double overDraft;

    private String type;

    private double interestRate;


    private AccountStatus status;
}
