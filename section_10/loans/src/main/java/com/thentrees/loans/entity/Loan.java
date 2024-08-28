package com.thentrees.loans.entity;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 11:52
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "loans")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    private String mobileNumber;

    private String loanNumber;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;

}