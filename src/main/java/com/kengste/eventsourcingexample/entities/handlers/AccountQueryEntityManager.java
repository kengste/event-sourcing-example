package com.kengste.eventsourcingexample.entities.handlers;

import com.kengste.eventsourcingexample.aggregates.AccountAggregate;
import com.kengste.eventsourcingexample.entities.AccountQueryEntity;
import com.kengste.eventsourcingexample.entities.repositories.AccountRepository;
import com.kengste.eventsourcingexample.events.BaseEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AccountQueryEntityManager {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired @Qualifier("accountAggregateEventSourcingRepository")
    private EventSourcingRepository<AccountAggregate> accountAggregateEventSourcingRepository;

    @EventSourcingHandler
    void on(BaseEvent event){
        persistAccount(buildQueryAccount(getAccountFromEvent(event)));
    }

    private AccountAggregate getAccountFromEvent(BaseEvent event){
        return accountAggregateEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
    }

    private AccountQueryEntity findExistingOrCreateQueryAccount(String id){
        return accountRepository.findById(id).isPresent() ? accountRepository.findById(id).get() : new AccountQueryEntity();
    }

    private AccountQueryEntity buildQueryAccount(AccountAggregate accountAggregate){
        AccountQueryEntity accountQueryEntity = findExistingOrCreateQueryAccount(accountAggregate.getId());

        accountQueryEntity.setId(accountAggregate.getId());
        accountQueryEntity.setAccountBalance(accountAggregate.getAccountBalance());
        accountQueryEntity.setCurrency(accountAggregate.getCurrency());
        accountQueryEntity.setStatus(accountAggregate.getStatus());

        return accountQueryEntity;
    }

    private void persistAccount(AccountQueryEntity accountQueryEntity){
        accountRepository.save(accountQueryEntity);
    }
}

// Inject an instance of AccountRepository into the AccountQueryEntityManager

// Inject an instance of EventSourcingRepository for AccountAggregate

// A method annotated with @EventSourcingHandler is declared to handle the events occurring on the aggregate

// Use the EventSourcingRepository instance to extract the correct AccountAggregate object from the event store

// If found, we use the values from the AccountAggregate object to populate the AccountQueryEntity object

// If not found, we create a new instance of the AccountQueryEntity

// Finally, we use the AccountRepository to save the AccountQueryEntity instance to the query store