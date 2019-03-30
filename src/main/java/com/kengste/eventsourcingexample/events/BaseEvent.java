package com.kengste.eventsourcingexample.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseEvent<T> {

    @TargetAggregateIdentifier
    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}

// Generics is used to make id field flexible across different classes extending from BaseEvent class

// @TargetAggregateIdentifier is used by Axon to identify the Aggregate instance to handle the event