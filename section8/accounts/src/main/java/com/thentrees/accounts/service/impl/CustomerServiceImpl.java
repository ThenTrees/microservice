package com.thentrees.accounts.service.impl;

import com.thentrees.accounts.dto.AccountDto;
import com.thentrees.accounts.dto.CardDto;
import com.thentrees.accounts.dto.CustomerDetailsDto;
import com.thentrees.accounts.dto.LoanDto;
import com.thentrees.accounts.entity.Account;
import com.thentrees.accounts.entity.Customer;
import com.thentrees.accounts.exception.ResourceNotFoundException;
import com.thentrees.accounts.mapper.AccountMapper;
import com.thentrees.accounts.mapper.CustomerMapper;
import com.thentrees.accounts.repository.AccountRepository;
import com.thentrees.accounts.repository.CustomerRepository;
import com.thentrees.accounts.service.ICustomerService;
import com.thentrees.accounts.service.client.CardsFeignClient;
import com.thentrees.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:47
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.maptoCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountMapper.mapToAccountsDto(account,new AccountDto()));

        ResponseEntity<CardDto> cardDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardDto(cardDtoResponseEntity.getBody());

        ResponseEntity<LoanDto> loanDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoanDto(loanDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}



