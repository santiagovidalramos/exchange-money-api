package com.svidal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoneyExchangeResponse {
    private Double amount;
    private Double amountConverted;
    private String source;
    private String destiny;
    private Double change;
}
