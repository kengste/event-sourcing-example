package com.kengste.eventsourcingexample.events;

import com.kengste.eventsourcingexample.aggregates.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}