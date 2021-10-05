package demo.plane;

import demo.plane.dto.CreatePlaneRequest;
import demo.plane.service.PlaneCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/plane")
public class PlaneController {


    private final PlaneCommandService planeCommandService;

    public PlaneController(PlaneCommandService planeCommandService) {
        this.planeCommandService = planeCommandService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createPlane(@RequestBody CreatePlaneRequest request) {
        try {
            CompletableFuture<String> response =
                    planeCommandService.createPlane(request);

            return new ResponseEntity<>(response.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
