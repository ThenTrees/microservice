package com.thentrees.accounts.service.client;/*
 * @author: Thentrees
 * @since: 31/07/2024 : 23:29
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import com.thentrees.accounts.dto.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "cards", fallback = CardsFallback.class)
public interface CardsFeignClient {

    @GetMapping("/api/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestHeader("thentrees-correlation-id") String correlationId,
                                                    @RequestParam String mobileNumber);
}
