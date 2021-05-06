package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.ResponseDTO;
import lt.augi58.wroom.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/create-update-part", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createUpdate(@RequestBody InventoryItemDTO inventoryItemDTO) {
        return inventoryService.createUpdate(inventoryItemDTO) != null ?
                ResponseEntity.ok(new ResponseDTO(true, "New part has been created")) :
                ResponseEntity.ok(new ResponseDTO(false, "Something went wrong"));
    }

}
