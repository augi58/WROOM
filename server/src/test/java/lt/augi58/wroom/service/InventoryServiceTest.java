package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.utils.PartIdentifierUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class InventoryServiceTest extends BaseTest {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    VehicleService vehicleService;

    @Test
    public void test_getAllSuitableParts() {
        AtomicBoolean result = new AtomicBoolean(false);
        VehicleDTO testMotorcycle = vehicleService.get(4L);
        String partIdentifier = PartIdentifierUtils.partIdentifierConstructor(testMotorcycle);
        List<InventoryItemDTO> parts = inventoryService.getAllSuitable(testMotorcycle.getId());
        Assertions.assertNotNull(parts);
        parts = parts.stream().filter(part -> part.getFitsFor().size() != 0).collect(Collectors.toList());
        parts.forEach(part -> part.getFitsFor().forEach(fitment -> {
            if (fitment.equals(partIdentifier)) {
                result.set(true);
            }
        }));
        Assertions.assertTrue(result.get());
    }

}
