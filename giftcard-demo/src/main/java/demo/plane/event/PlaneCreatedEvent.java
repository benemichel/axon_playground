package demo.plane.event;



// just POJO
public class PlaneCreatedEvent {

    // we marked the fields in the commands as final. This is intentional, as it's a
    // best practice for any message implementation to be immutable
    private final String id;
    private final int speed;

    public PlaneCreatedEvent(String id, int speed) {
        this.id = id;
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }
    public String getId() {return this.id;}
}
