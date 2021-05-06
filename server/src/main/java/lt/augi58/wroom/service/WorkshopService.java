package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.WorkshopDTO;

public interface WorkshopService {

    WorkshopDTO createUpdate(WorkshopDTO workshopDTO);

    WorkshopDTO get(Long workshopId);

    boolean delete(Long workshopId);
}
