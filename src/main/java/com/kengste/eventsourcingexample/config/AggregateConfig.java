package com.kengste.eventsourcingexample.config;

import com.kengste.eventsourcingexample.aggregates.AccountAggregate;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AggregateConfig {

    @Bean
    EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository(EventStore eventStore){
        EventSourcingRepository<AccountAggregate> repository =
            EventSourcingRepository.builder(AccountAggregate.class).eventStore(eventStore).build();
        return repository;
    }
}
