package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.model.InventoryItemJPA;
import lt.augi58.wroom.repository.InventoryItemDAO;
import lt.augi58.wroom.service.InventoryService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryItemDAO inventoryItemDAO;

    @Override
    public InventoryItemDTO addItem(InventoryItemDTO inventoryItemDTO) {
        if (inventoryItemDTO.getId() == null) {
            InventoryItemJPA newItem = new InventoryItemJPA();
            ObjectMapperUtils.map(inventoryItemDTO, newItem);
            inventoryItemDAO.create(newItem);
            return inventoryItemDTO;
        } else {
            return null;
        }
    }

    @Override
    public List<InventoryItemDTO> getAll() {
        List<InventoryItemJPA> items = inventoryItemDAO.findAll();
        return ObjectMapperUtils.mapAll(items, InventoryItemDTO.class);
    }

    @Override
    public List<InventoryItemDTO> getByJobId(Long jobId) {
        return null;
    }

    @Override
    public InventoryItemDTO get(Long itemId) {
        return null;
    }

    @Override
    public boolean delete(Long itemId) {
        return false;
    }
}
