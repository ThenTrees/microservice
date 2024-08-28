package com.thentrees.accounts.dto;

/*
 * @author: Thentrees
 * @since: 31/07/2024 : 23:33
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "CustomerDetails",
        description = "Schema to hold Account,Card and Loan information"
)
@Data
public class CustomerDetailsDto {

    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "tutor@eazybytes.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountDto accountsDto;

    @Schema(
            description = "Card details of the Customer"
    )
    private CardDto cardDto;

    @Schema(
            description = "Loans details of the Customer"
    )
    private LoanDto loanDto;
}
