package com.kengste.eventsourcingexample.entities.repositories;

import com.kengste.eventsourcingexample.entities.AccountQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountQueryEntity, String> {
}