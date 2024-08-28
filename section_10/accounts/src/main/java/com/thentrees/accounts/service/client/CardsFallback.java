package com.thentrees.accounts.service.client;

import com.thentrees.accounts.dto.CardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/*
 * @author: Thentrees
 * @since: 24/08/2024 : 22:41
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Component
public class CardsFallback implements CardsFeignClient{
    @Override
    public ResponseEntity<CardDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return null;
    }
}
