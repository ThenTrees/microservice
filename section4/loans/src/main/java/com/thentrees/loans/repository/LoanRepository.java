package com.thentrees.loans.repository;

import com.thentrees.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 11:52
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByMobileNumber(String mobileNumber);

    Optional<Loan> findByLoanNumber(String loanNumber);

}
