package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO createUpdate(VehicleDTO vehicle);

    VehicleDTO get(Long vehicleId);

    List<VehicleDTO> getClientVehicles(Long clientId);

    boolean delete(Long vehicleId);
}
