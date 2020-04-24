package com.svidal.service;

import com.svidal.dto.Mapper;
import com.svidal.dto.MoneyExchangeRequest;
import com.svidal.dto.MoneyExchangeResponse;
import com.svidal.entity.Log;
import com.svidal.entity.Change;
import com.svidal.repository.LogRepository;
import com.svidal.repository.ChangeRepository;
import com.svidal.util.Format;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ExchangeCommandImpl implements ExchangeCommand{
    @Autowired
    ChangeRepository repository;
    @Autowired
    LogRepository logRepository;
    @Autowired
    Mapper mapper;

    @Override
    public Single<MoneyExchangeResponse> execute(MoneyExchangeRequest request) {
        return Single.create(singleSubscriber -> {
            Change change = repository.findBySourceAndDestiny(request.getSource(),request.getDestiny());
            if (change ==null)
                singleSubscriber.onError(new EntityNotFoundException());
            else {
                Double amountConverted= Format.decimal(request.getAmount()* change.getChange());
                Log log=new Log();
                log.setChange(change);
                log.setAmount(request.getAmount());
                log.setAmountConverted(amountConverted);
                log=logRepository.save(log);
                singleSubscriber.onSuccess(mapper.toResponse(log));
            }
        });
    }
}
