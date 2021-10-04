package io.axoniq.demo.giftcard.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class PlaneCreatedCommand {

    @TargetAggregateIdentifier
    private String id;
    private int speed;

    public PlaneCreatedCommand(String id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public String getId() { return this.id;}

}
