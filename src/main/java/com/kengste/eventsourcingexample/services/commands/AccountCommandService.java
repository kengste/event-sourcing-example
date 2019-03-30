package com.kengste.eventsourcingexample.services.commands;

import com.kengste.eventsourcingexample.dto.commands.AccountCreateDTO;
import com.kengste.eventsourcingexample.dto.commands.MoneyCreditDTO;
import com.kengste.eventsourcingexample.dto.commands.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
