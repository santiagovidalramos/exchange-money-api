package com.svidal.dto;

import com.svidal.entity.Log;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public MoneyExchangeResponse toResponse(Log log) {
        MoneyExchangeResponse response=new MoneyExchangeResponse();
        response.setAmount(log.getAmount());
        response.setAmountConverted(log.getAmountConverted());
        response.setSource(log.getChange().getSource());
        response.setDestiny(log.getChange().getDestiny());
        response.setChange(log.getChange().getChange());
        return response;
    }
}
