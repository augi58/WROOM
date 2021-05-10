package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUpdate(UserDTO userDTO);

    List<UserDTO> getClients(Long account);

    List<UserDTO> getTechnicians(Long accountId);

    UserDTO addClient(UserDTO client);

    UserDTO get(Long userId);

    boolean delete(Long userId);
}
