package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.AccountDTO;
import lt.augi58.wroom.repository.AccountDAO;
import lt.augi58.wroom.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public AccountDTO createUpdate(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO get(Long accountId) {
        return null;
    }

    @Override
    public boolean delete(Long accountId) {
        return false;
    }
}
