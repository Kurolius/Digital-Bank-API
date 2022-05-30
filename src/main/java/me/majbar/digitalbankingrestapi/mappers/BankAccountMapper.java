package me.majbar.digitalbankingrestapi.mappers;

import lombok.AllArgsConstructor;
import me.majbar.digitalbankingrestapi.dtos.BankAccountRequestDTO;
import me.majbar.digitalbankingrestapi.dtos.CurrentBankAccountDTO;
import me.majbar.digitalbankingrestapi.dtos.SavingBankAccountDTO;
import me.majbar.digitalbankingrestapi.entities.CurrentAccount;
import me.majbar.digitalbankingrestapi.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankAccountMapper {

    private CustomerMapper customerMapper;

    public SavingAccount fromSavingAccountDTO(SavingBankAccountDTO savingBankAccountDTO){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties( savingBankAccountDTO, savingAccount);
        savingAccount.setCustomer( customerMapper.fromCustomerDto( savingBankAccountDTO.getCustomer() ) );
        return savingAccount;
    }

    public SavingBankAccountDTO fromSavingAccount(SavingAccount savingBankAccount){
        SavingBankAccountDTO savingAccountDto = new SavingBankAccountDTO();
        BeanUtils.copyProperties( savingBankAccount, savingAccountDto);
        savingAccountDto.setCustomer( customerMapper.fromCustomer( savingBankAccount.getCustomer() ) );
        savingAccountDto.setType( savingBankAccount.getClass().getSimpleName() );
        return savingAccountDto;
    }


    public CurrentAccount fromCurrentAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties( currentBankAccountDTO, currentAccount);
        currentAccount.setCustomer( customerMapper.fromCustomerDto( currentBankAccountDTO.getCustomer() ) );
        return currentAccount;
    }

    public CurrentBankAccountDTO fromCurrentAccount( CurrentAccount currentAccount){
        CurrentBankAccountDTO currentAccountDTO = new CurrentBankAccountDTO();
        BeanUtils.copyProperties( currentAccount, currentAccountDTO);
        currentAccountDTO.setCustomer( customerMapper.fromCustomer( currentAccount.getCustomer() ) );
        currentAccountDTO.setType( currentAccount.getClass().getSimpleName() );
        return currentAccountDTO;
    }

    public SavingAccount savingAccountFromBankAccountRequestDto(BankAccountRequestDTO bankAccountRequestDTO){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties( bankAccountRequestDTO, savingAccount);
        savingAccount.setCustomer( customerMapper.fromCustomerDto( bankAccountRequestDTO.getCustomer() ) );
        return savingAccount;
    }

    public CurrentAccount currentAccountFromBankAccountRequestDto(BankAccountRequestDTO bankAccountRequestDTO){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties( bankAccountRequestDTO, currentAccount);
        currentAccount.setCustomer( customerMapper.fromCustomerDto( bankAccountRequestDTO.getCustomer() ) );
        return currentAccount;
    }

}
