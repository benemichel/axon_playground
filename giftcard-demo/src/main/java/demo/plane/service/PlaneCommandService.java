package demo.plane.service;

import demo.plane.command.CreatePlaneCommand;
import demo.plane.dto.CreatePlaneRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PlaneCommandService {

    private CommandGateway commandGateway;

    public PlaneCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createPlane(CreatePlaneRequest createPlaneRequest) {
        return commandGateway.send(new CreatePlaneCommand(
                UUID.randomUUID().toString(),
                createPlaneRequest.getSpeed())
        );
    }
}
