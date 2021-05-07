package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.model.InventoryItemJPA;
import lt.augi58.wroom.model.WorkshopJPA;
import lt.augi58.wroom.repository.InventoryItemDAO;
import lt.augi58.wroom.repository.WorkshopDAO;
import lt.augi58.wroom.service.InventoryService;
import lt.augi58.wroom.service.VehicleService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryItemDAO inventoryItemDAO;
    @Autowired
    WorkshopDAO workshopDAO;
    @Autowired
    VehicleService vehicleService;

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
    public List<InventoryItemDTO> getAllSuitable(Long vehicleId) {
        List<InventoryItemDTO> parts = getAll();
        List<InventoryItemDTO> suitableParts = new ArrayList<>();
        VehicleDTO vehicle = vehicleService.get(vehicleId);
        String vehicleIdentifier = vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel();
        parts.forEach(part -> {
            if (is_suitable.test(part, vehicleIdentifier)) {
                suitableParts.add(part);
            }
        });
        return suitableParts;
    }

    private final BiPredicate<InventoryItemDTO, String> is_suitable = (part, vehicleIdentifier) -> {
        AtomicBoolean fits = new AtomicBoolean(false);
        if (part.getFitsFor() == null || part.getFitsFor().size() == 0) {
            return true;
        }
        part.getFitsFor().forEach(fitsFor -> {
            if (fitsFor.trim().toUpperCase().equals(vehicleIdentifier.trim().toUpperCase())) {
                fits.set(true);
            }
        });
        return fits.get();
    };

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
