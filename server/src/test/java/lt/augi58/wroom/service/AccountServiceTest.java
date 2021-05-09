package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.AccountDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

    @Autowired
    AccountService accountService;
    @Autowired
    UserService userService;

    @Test
    public void createUpdate() {
        var createdAccount = givenAccount();
        assert (createdAccount.getId().equals(12355L));
    }

    @Test
    public void get() {
        var createdAccount = givenAccount();

        Assert.assertEquals(
                accountService.get(createdAccount.getId()).getName(),
                createdAccount.getName()
        );
    }

    @Test
    public void delete() {
        var createdAccount = givenAccount();

        accountService.delete(createdAccount.getId());

        Assertions.assertThrows(NullPointerException.class, () -> accountService.get(createdAccount.getId()));
    }


    private AccountDTO givenAccount() {
        var account = new AccountDTO();

//        account.setId(12355L);
        account.setName("Jackson");
        account.setUsers((List<UserDTO>) userService.get(givenUser().getId()));

        return accountService.createUpdate(account);
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
}