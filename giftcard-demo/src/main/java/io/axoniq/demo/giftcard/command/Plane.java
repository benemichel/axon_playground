package io.axoniq.demo.giftcard.command;


import io.axoniq.demo.giftcard.event.PlaneCreatedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class Plane {

    @AggregateIdentifier
    private String id;
    private int speed;

    @CommandHandler
    public Plane(PlaneCreatedCommand command) {
        if (command.getSpeed() <= 0) {
            throw new IllegalArgumentException("speed <= 0");
        }
        apply(new PlaneCreatedEvent(command.getId(), command.getSpeed()));
    }

    @EventSourcingHandler
    public void on(PlaneCreatedEvent planeCreatedEvent) {
        this.id = planeCreatedEvent.getId();
        this.speed = planeCreatedEvent.getSpeed();
    }



}
