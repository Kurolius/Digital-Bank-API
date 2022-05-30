package me.majbar.digitalbankingrestapi.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.majbar.digitalbankingrestapi.dtos.AccountOperationDTO;
import me.majbar.digitalbankingrestapi.dtos.CreditDTO;
import me.majbar.digitalbankingrestapi.dtos.DebitDTO;
import me.majbar.digitalbankingrestapi.dtos.TransferRequestDTO;
import me.majbar.digitalbankingrestapi.exceptions.BalanceNotSufficientException;
import me.majbar.digitalbankingrestapi.exceptions.BankAccountNotFoundExcetion;
import me.majbar.digitalbankingrestapi.exceptions.OperationNotFoundException;
import me.majbar.digitalbankingrestapi.services.AccountOperationService;
import me.majbar.digitalbankingrestapi.services.BankAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class OperationRestController {


    private AccountOperationService operationService;
    private BankAccountService accountService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/operations/{id}")
    public AccountOperationDTO getOperation( @PathVariable("id") long operationId) throws OperationNotFoundException {
        return operationService.getOperation( operationId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/debit")
    public DebitDTO debiter( @RequestBody DebitDTO debitDTO) throws BankAccountNotFoundExcetion, BalanceNotSufficientException {

        accountService.debit( debitDTO.getAccountId(), debitDTO.getAmount(), debitDTO.getDescription() );
        return debitDTO;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundExcetion {

        accountService.credit( creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription() );
        return creditDTO;

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/operations/transfer")
    public TransferRequestDTO transferer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundExcetion, BalanceNotSufficientException {

        accountService.transfer(
                transferRequestDTO.getAccountSourceId(),
                transferRequestDTO.getAccountDestinationId(),
                transferRequestDTO.getAmount(),
                transferRequestDTO.getDescription()
        );
        return transferRequestDTO;

    }


}
