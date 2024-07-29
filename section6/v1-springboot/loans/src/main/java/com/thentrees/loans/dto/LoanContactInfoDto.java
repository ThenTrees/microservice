package com.thentrees.loans.dto;/*
 * @author: Thentrees
 * @since: 29/07/2024 : 15:35
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
public record LoanContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}