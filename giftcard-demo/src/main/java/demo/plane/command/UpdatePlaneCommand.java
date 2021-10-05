package demo.plane.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdatePlaneCommand {

    // tells Axon that the annotated field is an id of a given aggregate to which the command should be targeted
    @TargetAggregateIdentifier
    private final String id;
    private final int speed;
    // we marked the fields in the commands as final. This is intentional, as it's a
    // best practice for any message implementation to be immutable

    public UpdatePlaneCommand(String id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public String getId() { return this.id;}
}
