package me.majbar.digitalbankingrestapi.services;


import me.majbar.digitalbankingrestapi.dtos.*;
import me.majbar.digitalbankingrestapi.entities.BankAccount;
import me.majbar.digitalbankingrestapi.entities.CurrentAccount;
import me.majbar.digitalbankingrestapi.entities.SavingAccount;
import me.majbar.digitalbankingrestapi.exceptions.BalanceNotSufficientException;
import me.majbar.digitalbankingrestapi.exceptions.BankAccountNotFoundExcetion;
import me.majbar.digitalbankingrestapi.exceptions.CustomerNotFoundException;

import java.util.List;


public interface BankAccountService {


    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, String customerId) throws CustomerNotFoundException;

    BankAccountDTO updateCurrentBankAccount(CurrentAccount currentAccount) throws BankAccountNotFoundExcetion;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, String customerId) throws CustomerNotFoundException;


    BankAccountDTO updateSavingBankAccount(SavingAccount savingAccount) throws BankAccountNotFoundExcetion;

    BankAccountDTO getBankAccount(String bankAccountId) throws BankAccountNotFoundExcetion;

    void debit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    void credit( String accountId, double amount, String description) throws BankAccountNotFoundExcetion;

    void transfer( String accountSourceId, String accountDestinationId, double amount, String description) throws BankAccountNotFoundExcetion, BalanceNotSufficientException;

    List<BankAccountDTO> listBankAccountDTO();

    void deleteAccount(String accountId);
}
