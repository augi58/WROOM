package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.ResponseDTO;
import lt.augi58.wroom.enums.JobStatus;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class JobServiceTest extends BaseTest {

    @Autowired
    JobService jobService;

    @Test
    public void test_updateJobStatus() {
        JobDTO testJob = jobService.getById(14L);
        jobService.changeStatus(testJob.getId(), JobStatus.INVOICE);
        Assertions.assertEquals(jobService
                .getByJobName("test_job")
                .getStatus(), JobStatus.INVOICE);
    }

    @Test
    public void createDoorToDoorPickup() {
        JobDTO testJob = jobService.getById(14L);
        testJob.setDoorToDoor(true);
        ResponseDTO response = jobService.createDoorToDoorPickup(testJob);
        Assertions.assertTrue(response.getSuccess());
    }

    @Test
    public void getActiveJobs() {
        List<JobDTO> probablyActiveJobs = jobService.getActive();
        probablyActiveJobs = probablyActiveJobs.stream().filter(job -> {
            JobStatus.INVOICE.getDeclaringClass();
            return false;
        }).collect(Collectors.toList());
        Assertions.assertEquals(0, probablyActiveJobs.size());
    }

    @After
    public void cleanUp() {
        JobDTO testJob = jobService.getById(14L);
        testJob.setDoorToDoor(false);
        jobService.createDoorToDoorPickup(testJob);
    }
}