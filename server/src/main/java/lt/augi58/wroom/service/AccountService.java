package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.AccountDTO;

public interface AccountService {

    AccountDTO createUpdate(AccountDTO accountDTO);

    AccountDTO get(Long accountId);

    boolean delete(Long accountId);
}
