package com.thentrees.accounts.mapper;

import com.thentrees.accounts.dto.AccountDto;
import com.thentrees.accounts.entity.Account;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:54
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public class AccountMapper {
    public static AccountDto mapToAccountsDto(Account accounts, AccountDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Account mapToAccounts(AccountDto accountsDto, Account accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
