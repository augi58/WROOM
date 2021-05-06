package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.ResponseDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/create-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createUpdate(@RequestBody UserDTO userDTO) {
        return userService.createUpdate(userDTO) != null ?
                ResponseEntity.ok(new ResponseDTO(true, "User has been added")) :
                ResponseEntity.ok(new ResponseDTO(false, "Something went wrong"));
    }

    @GetMapping(path = "/get-all-clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getClients() {
        return userService.getClients();
    }

    @GetMapping(path = "/get-all-technicians", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getTechnicians() {
        return userService.getTechnicians();
    }

}
