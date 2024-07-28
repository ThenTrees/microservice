package com.thentrees.cards.repository;

import com.thentrees.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 10:25
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByMobileNumber(String mobileNumber);

    Optional<Card> findByCardNumber(String cardNumber);
}
