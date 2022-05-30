package me.majbar.digitalbankingrestapi.mappers;

import me.majbar.digitalbankingrestapi.dtos.AccountOperationDTO;
import me.majbar.digitalbankingrestapi.entities.AccountOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AccountOperationMapper {

    public AccountOperationDTO fromAccountOperation ( AccountOperation accountOperation){
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        BeanUtils.copyProperties( accountOperation, accountOperationDTO);
        return  accountOperationDTO;
    }


}
