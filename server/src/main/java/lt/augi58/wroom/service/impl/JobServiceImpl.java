package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.model.InventoryItemJPA;
import lt.augi58.wroom.model.JobJPA;
import lt.augi58.wroom.model.UserJPA;
import lt.augi58.wroom.model.VehicleJPA;
import lt.augi58.wroom.repository.InventoryItemDAO;
import lt.augi58.wroom.repository.JobDAO;
import lt.augi58.wroom.repository.UserDAO;
import lt.augi58.wroom.repository.VehicleDAO;
import lt.augi58.wroom.service.JobService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobDAO jobDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    InventoryItemDAO inventoryItemDAO;
    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    public List<JobDTO> getAll() {
        return jobDAO.findAll().stream().map(JobJPA::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<JobDTO> getActive() {
        return getAll().stream().filter(is_active).collect(Collectors.toList());
    }

    private final Predicate<JobDTO> is_active = (job) -> !job.getStatus().equals(JobStatus.INVOICE);

    @Override
    @Transactional
    public JobDTO createUpdate(JobDTO job) {
        if (job.getId() == null) {
            JobJPA newJob = new JobJPA();
            UserJPA client = userDAO.getById(job.getClient().getId());
            newJob.setClient(client);
            UserJPA technician = userDAO.getById(job.getTechnician().getId());
            newJob.setTechnician(technician);
            VehicleJPA vehicleJPA = vehicleDAO.getById(job.getVehicle().getId());
            newJob.setVehicle(vehicleJPA);
            if (newJob.getParts() == null) {
                newJob.setParts(new HashSet<>());
            }
            job.getParts().forEach(partId -> {
                newJob.getParts().add(inventoryItemDAO.getById(partId));
            });
            newJob.setName(job.getName());
            newJob.setStatus(job.getStatus());
            newJob.setLabor(job.getLabor());
            newJob.setRate(job.getRate());
            newJob.setDueDate(job.getDueDate());
            newJob.setDoorToDoor(job.getDoorToDoor());
            newJob.setNotes(job.getNotes());
            jobDAO.create(newJob);
            return job;
        } else {
            JobJPA original = jobDAO.findById(job.getId()).orElse(null);
            JobJPA updated = new JobJPA();
            ObjectMapperUtils.map(original, updated);
            jobDAO.merge(updated);
            return job;
        }
    }

    @Override
    @Transactional
    public boolean changeStatus(Long jobId, JobStatus newStatus) {
        try {
            JobJPA job = jobDAO.findById(jobId).orElse(null);
            job.setStatus(newStatus);
            jobDAO.merge(job);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void createDoorToDoorPickup() {

    }

}
