package lt.augi58.wroom.service;

import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.enums.JobStatus;

import java.util.List;

public interface JobService {

    List<JobDTO> getAll();

    List<JobDTO> getActive();

    JobDTO createUpdate(JobDTO job);

    boolean changeStatus(Long jobId, JobStatus newStatus);

    void createDoorToDoorPickup();

}
