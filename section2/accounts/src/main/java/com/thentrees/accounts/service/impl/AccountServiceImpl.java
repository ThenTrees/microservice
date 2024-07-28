package com.thentrees.accounts.service.impl;

import com.thentrees.accounts.constant.AccountConstants;
import com.thentrees.accounts.dto.AccountDto;
import com.thentrees.accounts.dto.CustomerDto;
import com.thentrees.accounts.entity.Account;
import com.thentrees.accounts.entity.Customer;
import com.thentrees.accounts.exception.CustomerAlreadyExistsException;
import com.thentrees.accounts.exception.ResourceNotFoundException;
import com.thentrees.accounts.mapper.AccountMapper;
import com.thentrees.accounts.mapper.CustomerMapper;
import com.thentrees.accounts.repository.AccountRepository;
import com.thentrees.accounts.repository.CustomerRepository;
import com.thentrees.accounts.service.IAccountService;

import java.util.Optional;
import java.util.Random;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:43
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public class AccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * Create a new account for the customer
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    +customerDto.getMobileNumber());
        }
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(savedCustomer));
    }

    /**
     * Get the account details for the given mobile number
     * @param mobileNumber - input mobile number
     * @return CustomerDto Object
     */
    @Override
    public CustomerDto getAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountMapper.mapToAccountsDto(accounts, new AccountDto()));
        return customerDto;
    }

    /**
     * Update the account details for the given mobile number
     * @param customerDto - CustomerDto Object
     * @return true if account is updated successfully or false
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Account accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    /**
     * Delete the account for the given mobile number
     * @param mobileNumber - input mobile number
     * @return true if account is deleted successfully or false
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }

    private Account createNewAccount(Customer customer) {
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        return Account.builder()
                .accountNumber(randomAccNumber)
                .customerId(customer.getCustomerId())
                .accountType(AccountConstants.SAVINGS)
                .branchAddress(AccountConstants.ADDRESS)
                .build();
    }
}
