package me.majbar.digitalbankingrestapi.services;

import me.majbar.digitalbankingrestapi.dtos.CustomerAccountsDTO;
import me.majbar.digitalbankingrestapi.dtos.CustomerDTO;
import me.majbar.digitalbankingrestapi.dtos.CustomerPageableDTO;
import me.majbar.digitalbankingrestapi.entities.Customer;
import me.majbar.digitalbankingrestapi.exceptions.CustomerNotFoundException;


import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> listCustomers();

    CustomerDTO getCustomer(String customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException;

    void deleteCustomer(String customerId);

    List<CustomerDTO> searchCustomer( String searchKeyword);


    CustomerPageableDTO searchCustomerPaginated(int page, int size, String searchKeyword);

    CustomerAccountsDTO getCustomerAccounts(String customerId, int page, int size) throws CustomerNotFoundException;

    CustomerPageableDTO paginateCustomers(int page, int size);
}
