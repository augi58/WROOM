package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.VehicleDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class VehicleServiceTest extends BaseTest {
    @Autowired
    VehicleService vehicleService;

    @Test
    void createUpdate() {
        var createdVehicle = givenVehicle();
        assert (createdVehicle.getId().equals(1245L));
    }

    @Test
    void get() {
        var createdVehicle = givenVehicle();

        Assert.assertEquals(
                vehicleService.get(createdVehicle.getId()).getId(),
                createdVehicle.getId()
        );
    }

    @Test
    void getClientVehicles() {
        var createdVehicle = givenVehicle();

        Assert.assertEquals(
                vehicleService.getClientVehicles(createdVehicle.getId()),
                createdVehicle.getId()
        );
    }

    @Test
    void delete() {
        var createdVehicle = givenVehicle();
        vehicleService.delete(createdVehicle.getId());

        Assertions.assertThrows(NullPointerException.class, () -> vehicleService.get(createdVehicle.getId()));
    }


    private VehicleDTO givenVehicle() {
        var vehicle = new VehicleDTO();

        vehicle.setId(1245L);
        vehicle.setOwnerId(123455L);
        vehicle.setLicenceNo("WUE8542");
        vehicle.setMake("KTM");
        vehicle.setVIN("WDBUH82J84X162825");
        vehicle.setModel("EXC500");
        vehicle.setYear(2021);

        return vehicleService.createUpdate(vehicle);

    }
}