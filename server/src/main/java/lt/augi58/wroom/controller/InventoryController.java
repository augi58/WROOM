package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InventoryItemDTO> getPartsList() {
        return inventoryService.getAll();
    }

}
