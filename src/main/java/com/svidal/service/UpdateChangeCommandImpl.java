package com.svidal.service;

import com.svidal.dto.ChangeRequest;
import com.svidal.entity.Change;
import com.svidal.repository.ChangeRepository;
import io.reactivex.Completable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UpdateChangeCommandImpl implements UpdateChangeCommand{
    @Autowired
    ChangeRepository repository;

    @Override
    public Completable execute(Long changeId, ChangeRequest request) {
        return Completable.create(completableSubscriber -> {
            Optional<Change> optionalChange = repository.findById(changeId);
            if (!optionalChange.isPresent())
                completableSubscriber.onError(new EntityNotFoundException());
            else {
                Change change = optionalChange.get();
                change.setChange(request.getChange());
                repository.save(change);
                completableSubscriber.onComplete();
            }
        });
    }
}
