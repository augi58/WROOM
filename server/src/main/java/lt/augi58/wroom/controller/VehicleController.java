package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping(path = "/get-client-vehicles/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehicleDTO> getClientVehicles(@PathVariable("clientId") Long clientId) {
        return vehicleService.getClientVehicles(clientId);
    }

}
