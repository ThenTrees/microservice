package com.thentrees.accounts.repository;/*
 * @author: Thentrees
 * @since: 27/07/2024 : 13:41
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import com.thentrees.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerId(Long customerId);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
