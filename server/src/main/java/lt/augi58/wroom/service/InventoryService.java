package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.InventoryItemDTO;

import java.util.List;

public interface InventoryService {

    InventoryItemDTO createUpdate(InventoryItemDTO inventoryItemDTO);

    List<InventoryItemDTO> getAll();

    List<InventoryItemDTO> getByJobId(Long jobId);

    InventoryItemDTO get(Long itemId);

    boolean delete(Long itemId);

}
