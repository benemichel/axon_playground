package demo.plane.command;

import demo.plane.event.PlaneCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    private FixtureConfiguration<Plane> fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture<>(Plane.class);
    }

    @Test
    void handleCreateCommand() {
        String id = UUID.randomUUID().toString();
        int speed = 20;

//        CreatePlaneCommand createPlaneCommand = new CreatePlaneCommand(id, speed);

        fixture.givenNoPriorActivity()
                .when(new CreatePlaneCommand(id, speed))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new PlaneCreatedEvent(id, speed));
    }



    @Test
    void on() {
    }
}