package com.kengste.eventsourcingexample.sagas;

import com.kengste.eventsourcingexample.commands.DebitMoneyCommand;
import com.kengste.eventsourcingexample.events.MoneyCreditedEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

@Saga
public class DemoSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handle(MoneyCreditedEvent event) {
        // client generated identifiers
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");
        System.out.println("helloword helloword helloword helloword helloword helloword");

        commandGateway.send(
                new DebitMoneyCommand(
                        "f1c79dff-2993-4a82-b2b9-886994b01c4d",
                        114,
                        "string"));
        SagaLifecycle.end();
    }
}
