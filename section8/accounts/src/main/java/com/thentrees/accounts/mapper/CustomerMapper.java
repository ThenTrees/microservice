package com.thentrees.accounts.mapper;

import com.thentrees.accounts.dto.CustomerDetailsDto;
import com.thentrees.accounts.dto.CustomerDto;
import com.thentrees.accounts.entity.Customer;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:53
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerDetailsDto maptoCustomerDetailsDto(Customer customer, CustomerDetailsDto customerDetailsDto){
        customerDetailsDto.setName(customer.getName());
        customerDetailsDto.setEmail(customer.getEmail());
        customerDetailsDto.setMobileNumber(customer.getMobileNumber());
        return customerDetailsDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }


}
