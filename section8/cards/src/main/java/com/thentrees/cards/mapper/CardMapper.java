package com.thentrees.cards.mapper;

import com.thentrees.cards.dto.CardDto;
import com.thentrees.cards.entity.Card;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 10:13
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public class CardMapper {

    public static CardDto mapToCardsDto(Card card, CardDto cardDto) {
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setMobileNumber(card.getMobileNumber());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setAmountUsed(card.getAmountUsed());
        return cardDto;
    }

    public static Card mapToCards(CardDto cardDto, Card card) {
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setTotalLimit(cardDto.getTotalLimit());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setAmountUsed(cardDto.getAmountUsed());
        return card;
    }
}
