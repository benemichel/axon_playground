package demo.plane.event;

public class PlaneUpdatedEvent {

    // we marked the fields in the commands as final. This is intentional, as it's a
    // best practice for any message implementation to be immutable
    private final String id;
    private final int speed;

    public PlaneUpdatedEvent(String id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public String getId() {return this.id;}
}
