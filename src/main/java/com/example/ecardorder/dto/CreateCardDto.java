package com.example.ecardorder.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCardDto {
    @NotBlank(message = "Card name can not be null or empty")
    private String cardName;

    @NotBlank(message = "Card type can not be null or empty")
    private String cardType;

    @NotBlank(message = "Card number can not be null or empty")
    private String cardNumber;

    @Positive(message = "card duration must be positive")
    @NotNull(message = "Card duration can not be null or empty")
    private Integer cardDuration;

    @NotNull(message = "Card price can not be null or empty")
    @PositiveOrZero(message = "card price must be positive or zero")
    private BigDecimal cardPrice;


    private Boolean isActive;

}
