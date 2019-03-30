package com.kengste.eventsourcingexample.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}

// Generics is used to make id field flexible across different classes extending from BaseCommand class

// @TargetAggregateIdentifier is used by Axon to identify the Aggregate instance to handle the command