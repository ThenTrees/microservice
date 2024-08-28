package com.thentrees.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 10:28
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class CardAlreadyExistsException extends RuntimeException {
    public CardAlreadyExistsException(String message){
        super(message);
    }
}
