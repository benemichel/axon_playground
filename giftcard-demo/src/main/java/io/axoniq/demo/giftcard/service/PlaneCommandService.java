package io.axoniq.demo.giftcard.service;

import io.axoniq.demo.giftcard.command.PlaneCreatedCommand;
import io.axoniq.demo.giftcard.dto.CreatePlaneRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;

@Service
public class PlaneCommandService {

    private CommandGateway commandGateway;

    public PlaneCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> createPlane(CreatePlaneRequest createPlaneRequest) {
        return commandGateway.send(new PlaneCreatedCommand(
                UUID.randomUUID().toString(),
                createPlaneRequest.getSpeed())
        );
    }
}
