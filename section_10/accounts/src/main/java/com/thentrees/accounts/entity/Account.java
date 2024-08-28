package com.thentrees.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:30
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Entity(name="accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends BaseEntity{
    @Column(name="customer_id")
    private Long customerId;

    @Column(name="account_number")
    @Id
    private Long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;
}
