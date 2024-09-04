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
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:47
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final AccountRepository accountRepository;

    private final CustomerRepository customerRepository;

    private final CardsFeignClient cardsFeignClient;

    private final LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.maptoCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountMapper.mapToAccountsDto(account,new AccountDto()));

        ResponseEntity<CardDto> cardDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId,mobileNumber);
        if(cardDtoResponseEntity != null){
            customerDetailsDto.setCardDto(cardDtoResponseEntity.getBody());
        }

        ResponseEntity<LoanDto> loanDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId,mobileNumber);
        if(loanDtoResponseEntity != null){
            customerDetailsDto.setLoanDto(loanDtoResponseEntity.getBody());
        }
        return customerDetailsDto;
    }
}



