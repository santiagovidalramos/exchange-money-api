package com.svidal.rest;

import com.svidal.dto.BaseResponse;
import com.svidal.dto.ChangeRequest;
import com.svidal.dto.Mapper;
import com.svidal.dto.MoneyExchangeRequest;
import com.svidal.service.ExchangeCommand;
import com.svidal.service.UpdateChangeCommand;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/change")
public class ChangeRestController {
    @Autowired
    ExchangeCommand exchangeCommand;

    @PostMapping(
            value = "/money",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseResponse>> exchangeMoney(@RequestBody MoneyExchangeRequest addAuthorWebRequest) {
        return exchangeCommand.execute((addAuthorWebRequest))
                .subscribeOn(Schedulers.io())
                .map(response -> ResponseEntity.ok(BaseResponse.successWithData(response)));
    }

    @Autowired
    UpdateChangeCommand updateChangeCommand;
    @PostMapping(
            value = "/{changeId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<BaseResponse>> updateChange(@PathVariable(value = "changeId") Long changeId,
                                                              @RequestBody ChangeRequest request) {
        return updateChangeCommand.execute(changeId, request)
                .subscribeOn(Schedulers.io())
                .toSingle(() -> ResponseEntity.ok(BaseResponse.successNoData()));
    }
}
