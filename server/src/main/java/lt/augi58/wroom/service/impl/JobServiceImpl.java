package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.UserDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.model.JobJPA;
import lt.augi58.wroom.model.UserJPA;
import lt.augi58.wroom.repository.InventoryItemDAO;
import lt.augi58.wroom.repository.JobDAO;
import lt.augi58.wroom.repository.UserDAO;
import lt.augi58.wroom.service.JobService;
import lt.augi58.wroom.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobDAO jobDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    InventoryItemDAO inventoryItemDAO;

    @Override
    public List<JobDTO> getAll() {
        List<JobJPA> jobs = jobDAO.findAll();
        return ObjectMapperUtils.mapAll(jobs, JobDTO.class);
    }

    @Override
    @Transactional
    public JobDTO createUpdate(JobDTO job) {
        if (job.getId() == null) {
            JobJPA newJob = new JobJPA();
            UserJPA client = userDAO.getById(job.getClientId());
            newJob.setClient(client);
            UserJPA technician = userDAO.getById(job.getTechnicianId());
            newJob.setTechnician(technician);
            if (newJob.getParts() == null) {
                newJob.setParts(new HashSet<>());
            }
            job.getParts().forEach(partId -> {
                newJob.getParts().add(inventoryItemDAO.getById(partId));
            });
            ObjectMapperUtils.map(job, newJob);
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
