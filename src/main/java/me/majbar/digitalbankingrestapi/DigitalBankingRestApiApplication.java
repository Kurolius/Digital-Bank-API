package me.majbar.digitalbankingrestapi;

import me.majbar.digitalbankingrestapi.dtos.BankAccountDTO;
import me.majbar.digitalbankingrestapi.dtos.CurrentBankAccountDTO;
import me.majbar.digitalbankingrestapi.dtos.CustomerDTO;
import me.majbar.digitalbankingrestapi.dtos.SavingBankAccountDTO;
import me.majbar.digitalbankingrestapi.exceptions.CustomerNotFoundException;
import me.majbar.digitalbankingrestapi.security.entities.AppRole;
import me.majbar.digitalbankingrestapi.security.entities.AppUser;
import me.majbar.digitalbankingrestapi.security.service.SecurityService;
import me.majbar.digitalbankingrestapi.services.BankAccountService;
import me.majbar.digitalbankingrestapi.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBankingRestApiApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner initSecurityDatas(SecurityService securityService){
		return args -> {
			securityService.addNewRole(new AppRole(null,"USER"));
			securityService.addNewRole(new AppRole(null,"ADMIN"));
			securityService.addNewUser( new AppUser( null, "user", "user", new ArrayList<>()));
			securityService.addNewUser( new AppUser( null, "admin", "admin", new ArrayList<>()));

			securityService.addRoleToUser( "user", "USER");
			securityService.addRoleToUser( "admin", "USER");
			securityService.addRoleToUser( "admin", "ADMIN");

		};
	}
	//@Bean
	CommandLineRunner commandLineRunner( BankAccountService bankAccountService, CustomerService customerService){
		return args -> {
			Stream.of("Majbar Yassine","Alaa Naoufal","Elhim Imane").forEach(name->{
				CustomerDTO customer=new CustomerDTO();
				customer.setName(name);
				customer.setEmail(name.replaceAll(" ", "")+"@gmail.com");
				customerService.saveCustomer(customer);
			});
			customerService.listCustomers().forEach(customer->{
				try {
					bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
					bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				}
			});
			List<BankAccountDTO> bankAccounts = bankAccountService.listBankAccountDTO();
			for (BankAccountDTO bankAccount:bankAccounts){
				for (int i = 0; i <10 ; i++) {
					String accountId;
					if(bankAccount instanceof SavingBankAccountDTO){
						accountId=((SavingBankAccountDTO) bankAccount).getId();
					} else{
						accountId=((CurrentBankAccountDTO) bankAccount).getId();
					}
					bankAccountService.credit(accountId,10000+Math.random()*120000,"Credit");
					bankAccountService.debit(accountId,1000+Math.random()*9000,"Debit");
				}
			}
		};
	}
}
