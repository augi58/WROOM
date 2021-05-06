package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.Role;
import lt.augi58.wroom.model.AccountJPA;
import lt.augi58.wroom.model.UserJPA;
import lt.augi58.wroom.repository.AccountDAO;
import lt.augi58.wroom.repository.UserDAO;
import lt.augi58.wroom.service.UserService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AccountDAO accountDAO;

    @Override
    @Transactional
    public UserDTO createUpdate(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            UserJPA newUser = new UserJPA();
            ObjectMapperUtils.map(userDTO, newUser);
            AccountJPA account = accountDAO.getById(userDTO.getAccountId());
            newUser.setAccount(account);
            userDAO.create(newUser);
        } else {
            UserJPA original = userDAO.findById(userDTO.getId()).orElse(null);
            UserJPA updated = new UserJPA();
            ObjectMapperUtils.map(original, updated);
            userDAO.merge(updated);
        }
        return userDTO;
    }

    @Override
    public List<UserDTO> getClients() {
        List<UserJPA> clients = userDAO.getAllClients();
        return ObjectMapperUtils.mapAll(clients, UserDTO.class);
    }

    @Override
    public List<UserDTO> getTechnicians() {
        List<UserJPA> technicians = userDAO.getAllTechnicians();
        return ObjectMapperUtils.mapAll(technicians, UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO addClient(UserDTO client) {
        client.setRole(Role.CLIENT);
        createUpdate(client);
        return client;
    }

    @Override
    public UserDTO get(Long userId) {
        UserJPA user = userDAO.findById(userId).orElse(null);
        UserDTO userDTO = new UserDTO();
        ObjectMapperUtils.map(user, userDTO);
        return userDTO;
    }

    @Override
    @Transactional
    public boolean delete(Long userId) {
        try {
            userDAO.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
