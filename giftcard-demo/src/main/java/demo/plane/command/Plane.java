package demo.plane.command;


import demo.plane.event.PlaneCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
@Slf4j
public class Plane {

    // As an aggregate will handle commands that are targeted to a specific aggregate instance,
    // we need to specify the identifier with the AggregateIdentifier annotation (@TargetAggregateIdentifier in command).
    @AggregateIdentifier
    private String id;
    private int speed;

    // decide (e.g. invariants) and notify rest of application
    @CommandHandler
    public Plane(CreatePlaneCommand command) {
        log.info("Plane: CreatePlaneCommand received.");
        if (command.getSpeed() <= 0) {
            throw new IllegalArgumentException("speed <= 0");
        }
        // publish event
        apply(new PlaneCreatedEvent(command.getId(), command.getSpeed()));
    }

    //
    @EventSourcingHandler
    public void on(PlaneCreatedEvent planeCreatedEvent) {
        log.info("Plane: An PlaneCreatedEvent occurred.");
        this.id = planeCreatedEvent.getId();
        this.speed = planeCreatedEvent.getSpeed();
    }



}
