package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.WorkshopDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class WorkshopServiceTest extends BaseTest {

    @Autowired
    WorkshopService workshopService;


    @Test
    void createUpdate() {
        var createdWorkshop = givenWorkshop();
        assert (createdWorkshop.getName().equals("MotorInjury"));
    }

    @Test
    void get() {
        var createdWorkshop = givenWorkshop();

        Assert.assertEquals(
                workshopService.get(createdWorkshop.getId()).getName(),
                createdWorkshop.getName()
        );
    }

    @Test
    void delete() {
        var createdWorkshop = givenWorkshop();

        workshopService.delete(createdWorkshop.getId());

        Assertions.assertThrows(NullPointerException.class, () -> workshopService.get(createdWorkshop.getId()));
    }


    private WorkshopDTO givenWorkshop() {
        var workshop = new WorkshopDTO();
        List<InventoryItemDTO> listFitsFor = List.of();


        workshop.setId(112245L);
        workshop.setName("MotorInjury");
        workshop.setAddress("Stikliu 55, Kaunas");
        workshop.setInventoryItems(listFitsFor);

        return workshopService.createUpdate(workshop);

    }

}