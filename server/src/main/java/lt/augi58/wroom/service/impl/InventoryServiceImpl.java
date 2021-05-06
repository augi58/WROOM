package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.model.InventoryItemJPA;
import lt.augi58.wroom.model.UserJPA;
import lt.augi58.wroom.model.WorkshopJPA;
import lt.augi58.wroom.repository.InventoryItemDAO;
import lt.augi58.wroom.repository.WorkshopDAO;
import lt.augi58.wroom.service.InventoryService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryItemDAO inventoryItemDAO;
    @Autowired
    WorkshopDAO workshopDAO;

    @Override
    @Transactional
    public InventoryItemDTO createUpdate(InventoryItemDTO inventoryItemDTO) {
        if (inventoryItemDTO.getId() == null) {
            InventoryItemJPA newItem = new InventoryItemJPA();
            ObjectMapperUtils.map(inventoryItemDTO, newItem);
            WorkshopJPA workshopJPA = workshopDAO.getById(inventoryItemDTO.getWorkshopId());
            newItem.setWorkshop(workshopJPA);
            inventoryItemDAO.create(newItem);
        } else {
            InventoryItemJPA original = inventoryItemDAO.findById(inventoryItemDTO.getId()).orElse(null);
            InventoryItemJPA updated = new InventoryItemJPA();
            ObjectMapperUtils.map(original, updated);
            inventoryItemDAO.merge(updated);
        }
        return inventoryItemDTO;
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
