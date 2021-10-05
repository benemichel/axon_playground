package demo.plane.command;


import demo.plane.event.PlaneCreatedEvent;
import demo.plane.event.PlaneUpdatedEvent;
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

    // decide (e.g. invariants) and notify rest of application
    @CommandHandler
    public Plane(UpdatePlaneCommand command) {
        log.info("Plane: UpdatePlaneCommand received.");
        if (command.getSpeed() <= 0) {
            throw new IllegalArgumentException("speed <= 0");
        }
        // publish event
        apply(new PlaneUpdatedEvent(command.getId(), command.getSpeed()));
    }

    //
    @EventSourcingHandler
    public void on(PlaneCreatedEvent event) {
        log.info("Plane: An PlaneCreatedEvent occurred.");
        this.id = event.getId();
        this.speed = event.getSpeed();
    }

    @EventSourcingHandler
    public void on(PlaneUpdatedEvent event) {
        log.info("Plane: An PlaneCreatedEvent occurred.");
        this.speed = event.getSpeed();
    }



}
