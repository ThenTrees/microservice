package com.thentrees.cards.service.impl;

import com.thentrees.cards.dto.CardDto;
import com.thentrees.cards.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 10:09
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Service
@AllArgsConstructor
public class CardService implements ICardService {
    @Override
    public void createCard(String mobileNumber) {

    }

    @Override
    public CardDto fetchCard(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateCard(CardDto cardsDto) {
        return false;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        return false;
    }
}
