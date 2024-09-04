package com.thentrees.loans.exception;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 11:55
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoanAlreadyExistsException extends RuntimeException {
    public LoanAlreadyExistsException(String message) {
        super(message);
    }
}
