package lt.augi58.wroom.controller;

import lt.augi58.wroom.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workshop")
public class WorkshopController {

    @Autowired
    WorkshopService workshopService;

}
