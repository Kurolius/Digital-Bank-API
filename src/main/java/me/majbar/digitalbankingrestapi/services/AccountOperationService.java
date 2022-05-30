package me.majbar.digitalbankingrestapi.services;

import me.majbar.digitalbankingrestapi.dtos.AccountHistoryDTO;
import me.majbar.digitalbankingrestapi.dtos.AccountOperationDTO;
import me.majbar.digitalbankingrestapi.exceptions.BankAccountNotFoundExcetion;
import me.majbar.digitalbankingrestapi.exceptions.OperationNotFoundException;

import java.util.List;

public interface AccountOperationService {

    public List<AccountOperationDTO> getAccountOperationsHistory(String accountId);

    public AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundExcetion;


    AccountOperationDTO getOperation(long operationId) throws OperationNotFoundException;
}
