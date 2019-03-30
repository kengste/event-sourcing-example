package com.kengste.eventsourcingexample.services.queries;

import com.kengste.eventsourcingexample.entities.AccountQueryEntity;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
    public AccountQueryEntity getAccount(String accountNumber);
}
