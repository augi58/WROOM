package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.enums.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class JobServiceTest extends BaseTest {

    @Autowired
    JobService jobService;
    UserService userService;
    VehicleService vehicleService;

    @Test
    void createUpdate() throws ParseException {
        var createdJob = givenJob();
        assert (createdJob.getName().equals("Head gasket changing"));
    }

    @Test
    void changeStatus() throws ParseException {
        var job = givenJob();

        assertTrue(
                jobService.changeStatus(job.getId(), JobStatus.DROPPED_OFF));

    }

    @Test
    void createDoorToDoorPickup() throws ParseException {
        jobService.createDoorToDoorPickup(givenJob());

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