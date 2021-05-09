package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.AccountDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.Role;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest extends BaseTest {
    @Autowired
    AccountService accountService;
    UserService userService;

    @Test
    void createUpdate() {
        var createdAccount = givenAccount();
        assert (createdAccount.getId().equals(12355L));
    }

    @Test
    void get() {
        var createdAccount = givenAccount();

        Assert.assertEquals(
                accountService.get(createdAccount.getId()).getName(),
                createdAccount.getName()
        );
    }

    @Test
    void delete() {
        var createdAccount = givenAccount();

        accountService.delete(createdAccount.getId());

        Assertions.assertThrows(NullPointerException.class, () -> accountService.get(createdAccount.getId()));
    }


    private AccountDTO givenAccount() {
        var account = new AccountDTO();

        account.setId(12355L);
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