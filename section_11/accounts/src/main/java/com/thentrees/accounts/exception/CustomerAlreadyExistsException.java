package com.thentrees.accounts.exception;

/*
 * @author: Thentrees
 * @since: 27/07/2024 : 14:05
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }

}
