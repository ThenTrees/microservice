package com.thentrees.gatewayserver.controllers;

/*
 * @author: Thentrees
 * @since: 24/08/2024 : 22:06
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

    @RequestMapping("/contactSupport")
    public Mono<String> contactSupport() {
        return Mono.just("An error occurred. Please try after some time or contact support team!!!");
    }

}
