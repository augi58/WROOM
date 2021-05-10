package lt.augi58.wroom.utils;

import lt.augi58.wroom.domain.VehicleDTO;

public class PartIdentifierUtils {

    public static String partIdentifierConstructor(VehicleDTO vehicle){
        return vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel();
    }

}
