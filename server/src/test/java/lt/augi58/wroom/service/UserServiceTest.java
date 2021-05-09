package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    void createUpdate() {
        var createdUser = givenUser();
        assert (createdUser.getName().equals("John"));
    }

    @Test
    void get() {
        var user = givenUser();

        Assertions.assertEquals(
                userService.get(user.getId()).getName(),
                user.getName()
        );
    }

    @Test
    void getClients() {
        var client = givenUserClient();

        Assertions.assertEquals(
                userService.get(client.getId()).getRole(),
                client.getRole()
        );
    }

    @Test
    void getTechnicians() {
        var technician = givenUserTechnician();

        Assertions.assertEquals(
                userService.get(technician.getId()).getRole(),
                technician.getRole()
        );
    }

    @Test
    void addClient() {
        var client = givenUserClient();

        Assertions.assertEquals(
                userService.addClient(client),
                client
        );
    }

    @Test
    void delete() {
        var user = givenUser();
        userService.delete(user.getId());

        Assertions.assertThrows(NullPointerException.class, () -> userService.get(user.getId()));
    }


    private UserDTO givenUser() {
        var user = new UserDTO();

        user.setRole(Role.ADMIN);
        user.setUsername("someUser");
        user.setEmail("test@example.lt");
        user.setName("John");
        user.setSurname("Bonham");
        user.setMobileNumber("123456");
        user.setAddress("Street 421");
        user.setAccountId(123L);

        return userService.createUpdate(user);
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