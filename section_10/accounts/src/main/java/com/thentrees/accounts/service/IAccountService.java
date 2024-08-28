package com.thentrees.accounts.service;/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:43
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import com.thentrees.accounts.dto.CustomerDto;

public interface IAccountService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - input mobile number
     * @return Account Detail based on a given mobile number
     */
    CustomerDto getAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
