package io.axoniq.demo.giftcard.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class PlaneCreatedEvent {

    private String id;
    private int speed;

    public PlaneCreatedEvent(String id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public String getId() {return this.id;}
}
