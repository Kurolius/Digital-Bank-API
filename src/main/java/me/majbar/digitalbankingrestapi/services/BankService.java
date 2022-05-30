package me.majbar.digitalbankingrestapi.services;

import me.majbar.digitalbankingrestapi.entities.BankAccount;
import me.majbar.digitalbankingrestapi.entities.CurrentAccount;
import me.majbar.digitalbankingrestapi.entities.SavingAccount;
import me.majbar.digitalbankingrestapi.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional // stops getting that LazyInitializationException
public class BankService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void consulter() {

        BankAccount bankAccount = bankAccountRepository.findById("23a366be-4355-4711-9ec6-ebf483098fd8").orElse(null);
        if (bankAccount != null) {
            System.out.println("############################################################");
            System.out.println("-id: " + bankAccount.getId());
            System.out.println("-balance: " + bankAccount.getBalance());
            System.out.println("-status: " + bankAccount.getStatus());
            System.out.println("-createdAt: " + bankAccount.getCreatedAt());
            System.out.println("-cutomer: " + bankAccount.getCustomer().getName());
            System.out.println("-account_type: " + bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("-overDraft: " + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("-rate: " + ((SavingAccount) bankAccount).getInterestRate());
            }
            bankAccount.getAccountAccountOperations().forEach(accountOperation -> {
                System.out.println("===================================================");
                System.out.println(accountOperation.getType());
                System.out.println(accountOperation.getOperationDate());
                System.out.println(accountOperation.getAmount());

            });
            System.out.println("===================================================");
            System.out.println("####################################");
        }
    }
}
