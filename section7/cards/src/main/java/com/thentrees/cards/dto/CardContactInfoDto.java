package com.thentrees.cards.dto;/*
 * @author: Thentrees
 * @since: 29/07/2024 : 15:18
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "cards")
@Getter
@Setter
public class CardContactInfoDto {
        private String message;
        private Map<String, String> contactDetails;
        private List<String> onCallSupport;
}