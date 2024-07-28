package com.thentrees.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @author: Thentrees
 * @since: 28/07/2024 : 10:33
 * @description: Create by Thentrees, one student major SE of IUH
 * @info-fb: TLTT289
 * */
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data
@AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;

}