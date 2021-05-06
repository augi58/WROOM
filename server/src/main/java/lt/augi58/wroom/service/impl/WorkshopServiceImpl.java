package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.WorkshopDTO;
import lt.augi58.wroom.model.WorkshopJPA;
import lt.augi58.wroom.repository.WorkshopDAO;
import lt.augi58.wroom.service.WorkshopService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    @Autowired
    WorkshopDAO workshopDAO;

    @Override
    public WorkshopDTO createUpdate(WorkshopDTO workshop) {
        if (workshop.getId() == null) {
            WorkshopJPA newWorkshop = new WorkshopJPA();
            ObjectMapperUtils.map(workshop, newWorkshop);
            workshopDAO.create(newWorkshop);
        } else {
            WorkshopJPA original = workshopDAO.findById(workshop.getId()).orElse(null);
            WorkshopJPA updated = new WorkshopJPA();
            ObjectMapperUtils.map(original, updated);
            workshopDAO.merge(updated);
        }
        return workshop;
    }

    @Override
    public WorkshopDTO get(Long workshopId) {
        WorkshopJPA workshopJPA = workshopDAO.getById(workshopId);
        WorkshopDTO workshopDTO = new WorkshopDTO();
        ObjectMapperUtils.map(workshopJPA, workshopDTO);
        return workshopDTO;
    }

    @Override
    public boolean delete(Long workshopId) {
        try {
            workshopDAO.deleteById(workshopId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
