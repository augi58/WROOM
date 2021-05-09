package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.enums.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryServiceTest extends BaseTest {

    @Autowired
    InventoryService inventoryService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    UserService userService;
    @Autowired
    JobService jobService;

    @Test
    void createUpdate() {
        var createItem = inventoryItemDTO();
        assert (createItem.getId().equals(1243335L));
    }

    @Test
    void get() {
        var createItem = inventoryItemDTO();

        Assertions.assertEquals(
                inventoryService.get(createItem.getId()).getName(),
                createItem.getName()
        );
    }

    @Test
    void getAllSuitable() {
        var givenVehicle = givenVehicle();
        var createItem = inventoryItemDTO();

        Assertions.assertEquals(
                inventoryService.getAllSuitable(givenVehicle.getId()),
                createItem.getName()
        );

    }
    @Test
    void getAllNotSuitable() {
        var givenWrongVehicle = givenWrongVehicle();
        var createItem = inventoryItemDTO();

        Assertions.assertNotEquals(
                inventoryService.getAllSuitable(givenWrongVehicle.getId()),
                createItem.getName()
        );

    }

    @Test
    void getAll() {
        var createItem = inventoryItemDTO();

        Assertions.assertEquals(
                inventoryService.getAll(),
                createItem.getName()
        );
    }

    @Test
    void delete() {

        var givenItem = inventoryItemDTO();
        inventoryService.delete(givenItem.getId());

        Assertions.assertThrows(NullPointerException.class, () -> inventoryService.get(givenItem.getId()));
    }

    @Test
    void getByJobId() throws ParseException {

        var givenJob = givenJob();
        inventoryService.getByJobId(givenJob.getId());

        Assertions.assertThrows(NullPointerException.class, () -> inventoryService.get(givenJob.getId()));
    }


    private InventoryItemDTO inventoryItemDTO() {
        var inventoryItem = new InventoryItemDTO();
        List<String> listFitsFor = Arrays.asList("1243335", "1245", "1231244", "123312122");

        inventoryItem.setId(1243335L);
        inventoryItem.setName("Head gasket LP2423412");
        inventoryItem.setMake("ATHENA");
        inventoryItem.setSerialNo("LP2423412");
        inventoryItem.setFitsFor(listFitsFor);
        inventoryItem.setWorkshopId(12423132L);
        inventoryItem.setQuantity(8);
        inventoryItem.setCost(30D);

        return inventoryService.createUpdate(inventoryItem);

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

    private VehicleDTO givenWrongVehicle() {
        var vehicle = new VehicleDTO();

        vehicle.setId(1245123123L);
        vehicle.setOwnerId(123455L);
        vehicle.setLicenceNo("WUE8532");
        vehicle.setMake("KTMs");
        vehicle.setVIN("WDBUH82J84X1625825");
        vehicle.setModel("EXC20");
        vehicle.setYear(2017);

        return vehicleService.createUpdate(vehicle);

    }

    private JobDTO givenJob() throws ParseException {
        var job = new JobDTO();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2021-05-17");
        List<InventoryItemDTO> listFitsFor = List.of();

        job.setId(1245L);
        job.setName("Head gasket changing");
        job.setClient(givenUserClient());
        job.setTechnician(givenUserTechnician());
        job.setVehicle(givenVehicle());
        job.setLabor(24D);
        job.setDoorToDoor(false);
        job.setDueDate(date);
        job.setNotes("Test notes");
        job.setParts(listFitsFor);
        job.setStatus(JobStatus.ESTIMATE);
        job.setRate(15D);


        return jobService.createUpdate(job);

    }

    private UserDTO givenUserTechnician() {
        var user = new UserDTO();

        user.setRole(Role.TECHNICIAN);
        user.setUsername("someUser");
        user.setEmail("test@example.lt");
        user.setName("John");
        user.setSurname("Bonham");
        user.setMobileNumber("123456");
        user.setAddress("Street 421");
        user.setAccountId(123L);
        return userService.createUpdate(user);
    }

    private UserDTO givenUserClient() {
        var user = new UserDTO();

        user.setRole(Role.CLIENT);
        user.setUsername("someUser");
        user.setEmail("test@example.lt");
        user.setName("John");
        user.setSurname("Bonham");
        user.setMobileNumber("123456");
        user.setAddress("Street 421");
        user.setAccountId(123L);

        return userService.createUpdate(user);
    }
}
