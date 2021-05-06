package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.VehicleDTO;
import lt.augi58.wroom.model.VehicleJPA;
import lt.augi58.wroom.repository.VehicleDAO;
import lt.augi58.wroom.service.VehicleService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    public VehicleDTO createUpdate(VehicleDTO vehicle) {
        if (vehicle.getId() == null) {
            VehicleJPA newVehicle = new VehicleJPA();
            ObjectMapperUtils.map(vehicle, newVehicle);
            vehicleDAO.create(newVehicle);
        } else {
            VehicleJPA original = vehicleDAO.findById(vehicle.getId()).orElse(null);
            VehicleJPA updated = new VehicleJPA();
            ObjectMapperUtils.map(original, updated);
            vehicleDAO.merge(updated);
        }
        return vehicle;
    }

    @Override
    public VehicleDTO get(Long vehicleId) {
        VehicleJPA vehicleJPA = vehicleDAO.getById(vehicleId);
        VehicleDTO vehicleDTO = new VehicleDTO();
        ObjectMapperUtils.map(vehicleJPA, vehicleDTO);
        return vehicleDTO;
    }

    @Override
    public List<VehicleDTO> getClientVehicles(Long clientId) {
        List<VehicleJPA> vehicleJPAS = vehicleDAO.getAllByUserId(clientId);
        return ObjectMapperUtils.mapAll(vehicleJPAS, VehicleDTO.class);
    }

    @Override
    public boolean delete(Long vehicleId) {
        try {
            vehicleDAO.deleteById(vehicleId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
