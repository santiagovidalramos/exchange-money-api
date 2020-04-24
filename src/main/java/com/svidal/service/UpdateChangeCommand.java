package com.svidal.service;

import com.svidal.dto.ChangeRequest;
import io.reactivex.Completable;

public interface UpdateChangeCommand {
    Completable execute(Long changeId, ChangeRequest request);
}
