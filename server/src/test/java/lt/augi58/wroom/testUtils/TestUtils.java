package lt.augi58.wroom.testUtils;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.enums.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static JobDTO createTestJob() {
        JobDTO job = new JobDTO();
        List<InventoryItemDTO> parts = new ArrayList<>();
        parts.add(createTestInventoryItem());
        job.setName("test_job");
        job.setClient(createTestClient());
        job.setTechnician(createTestTechnician());
        job.setVehicle(createTestMotorcycle());
        job.setLabor(24D);
        job.setDoorToDoor(false);
        job.setNotes("Test notes");
        job.setParts(parts);
        job.setStatus(JobStatus.ESTIMATE);
        job.setRate(15D);
        return job;
    }

    public static InventoryItemDTO createTestInventoryItem() {
        var inventoryItem = new InventoryItemDTO();
        List<String> listFitsFor = Collections.singletonList("2021 test_moto test_model");
        inventoryItem.setName("test_part");
        inventoryItem.setMake("part");
        inventoryItem.setSerialNo("serial");
        inventoryItem.setFitsFor(listFitsFor);
        inventoryItem.setWorkshopId(2L);
        inventoryItem.setQuantity(8);
        inventoryItem.setCost(30D);
        return inventoryItem;
    }

    public static UserDTO createTestTechnician() {
        UserDTO user = new UserDTO();
        user.setId(68L);
        user.setRole(Role.TECHNICIAN);
        user.setUsername("test_technician");
        user.setEmail("test@example.lt");
        user.setName("John");
        user.setSurname("Bonham");
        user.setMobileNumber("123456");
        user.setAddress("Street 421");
        user.setAccountId(123L);
        return user;
    }

    public static UserDTO createTestClient() {
        var user = new UserDTO();
        user.setId(67L);
        user.setRole(Role.CLIENT);
        user.setUsername("test_client");
        user.setEmail("test@example.lt");
        user.setName("John");
        user.setSurname("Bonham");
        user.setMobileNumber("123456");
        user.setAddress("Street 421");
        user.setAccountId(123L);
        return user;
    }

    public static VehicleDTO createTestMotorcycle() {
        var vehicle = new VehicleDTO();
        vehicle.setLicenceNo("PLATE");
        vehicle.setMake("test_moto");
        vehicle.setVIN("zzzzzz");
        vehicle.setModel("test_model");
        vehicle.setYear(2021);
        return vehicle;
    }

}
