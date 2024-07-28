package com.thentrees.accounts.repository;/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:42
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import com.thentrees.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
