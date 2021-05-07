package lt.augi58.wroom.controller;

import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.ResponseDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDTO> getAllJobs() {
        return jobService.getAll();
    }

    @GetMapping(path = "/get-active", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JobDTO> getActiveJobs() {
        return jobService.getActive();
    }


    @PostMapping(path = "/create-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> modify(@RequestBody JobDTO job) {
        return jobService.createUpdate(job) != null ?
                ResponseEntity.ok(new ResponseDTO(true, "New job has been created")) :
                ResponseEntity.ok(new ResponseDTO(false, "Something went wrong"));
    }

    @GetMapping(path = "/update-status/{jobId}/{newStatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> changeJobStatus(@PathVariable("jobId") Long jobId, @PathVariable("newStatus") String newStatus) {
        return jobService.changeStatus(jobId, JobStatus.valueOf(newStatus)) ?
                ResponseEntity.ok(new ResponseDTO(true, "Job status has been changed")) :
                ResponseEntity.ok(new ResponseDTO(false, "Something went wrong"));
    }

}
