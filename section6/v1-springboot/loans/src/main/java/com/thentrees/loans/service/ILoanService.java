package com.thentrees.loans.service;/*
 * @author: Thentrees
 * @since: 28/07/2024 : 11:53
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import com.thentrees.loans.dto.LoanDto;

public interface ILoanService {

    /**
     *
     * @param mobileNumber - Mobile Number of the Customer
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber - Input mobile Number
     *  @return Loan Details based on a given mobileNumber
     */
    LoanDto fetchLoan(String mobileNumber);

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateLoan(LoanDto loansDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    boolean deleteLoan(String mobileNumber);

}
