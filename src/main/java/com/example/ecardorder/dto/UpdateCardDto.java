package com.example.ecardorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCardDto {
    private Long id;
    private String cardName;
    private String cardType;
    private String cardNumber;
    private Integer cardDuration;
    private BigDecimal cardPrice;
    private Boolean isActive;

}
