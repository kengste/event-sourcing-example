package com.kengste.eventsourcingexample.controllers;

import com.kengste.eventsourcingexample.entities.AccountQueryEntity;
import com.kengste.eventsourcingexample.services.queries.AccountQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping("/{accountNumber}")
    public AccountQueryEntity getAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.getAccount(accountNumber);
    }

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);
    }
}

// The controllers mainly use the services created.
// The payload received is passed to the service that in turn uses the CommandGateway to trigger the commands.
// Then the response is mapped back to the output of the end-point.