package com.svidal.service;

import com.svidal.dto.MoneyExchangeRequest;
import com.svidal.dto.MoneyExchangeResponse;
import io.reactivex.Single;

public interface ExchangeCommand {
    Single<MoneyExchangeResponse> execute(MoneyExchangeRequest request);
}
