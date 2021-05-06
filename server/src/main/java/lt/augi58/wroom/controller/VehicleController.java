package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.ResponseDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/create-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createUpdate(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.createUpdate(vehicleDTO) != null ?
                ResponseEntity.ok(new ResponseDTO(true, "User has been added")) :
                ResponseEntity.ok(new ResponseDTO(false, "Something went wrong"));
    }

}
