package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/get-all-clients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getClients() {
        return userService.getClients();
    }

    @GetMapping(path = "/get-all-technicians", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getTechnicians() {
        return userService.getTechnicians();
    }

}
