package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.domain.InventoryItemDTO;
import lt.augi58.wroom.domain.JobDTO;
import lt.augi58.wroom.domain.SummaryDTO;
import lt.augi58.wroom.enums.JobStatus;
import lt.augi58.wroom.service.JobService;
import lt.augi58.wroom.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    JobService jobService;

    @Override
    public SummaryDTO getSummary() {
        List<JobDTO> jobs = jobService.getAll();
        SummaryDTO summary = new SummaryDTO();

        summary.setEstimatesOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.ESTIMATE)).count());
        summary.setEstimatesSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.ESTIMATE)).map(calculate_job_cost).mapToDouble(a -> a).sum());
        summary.setDroppedOffOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.DROPPED_OFF)).count());
        summary.setDroppedOffSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.DROPPED_OFF)).map(calculate_job_cost).mapToDouble(a -> a).sum());
        summary.setInProgressOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.IN_PROGRESS)).count());
        summary.setInProgressSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.IN_PROGRESS)).map(calculate_job_cost).mapToDouble(a -> a).sum());
        summary.setInvoicesOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.INVOICE)).count());
        summary.setInvoicesSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.INVOICE)).map(calculate_job_cost).mapToDouble(a -> a).sum());

        summary.setTotalOrders(summary.getEstimatesOrders() + summary.getDroppedOffOrders() + summary.getInProgressOrders() + summary.getInvoicesOrders());
        summary.setTotalSum(summary.getEstimatesSum() + summary.getDroppedOffSum() + summary.getInProgressSum() + summary.getInvoicesSum());

        summary.setDoorToDoorEstimatesOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.ESTIMATE) && job.getDoorToDoor()).count());
        summary.setDoorToDoorEstimatesSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.ESTIMATE) && job.getDoorToDoor()).map(calculate_job_cost).mapToDouble(a -> a).sum());
        summary.setDoorToDoorInProgressOrders(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.IN_PROGRESS) && job.getDoorToDoor()).count());
        summary.setDoorToDoorInProgressSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.IN_PROGRESS) && job.getDoorToDoor()).map(calculate_job_cost).mapToDouble(a -> a).sum());
        summary.setDoorToDoorDeliveredOrders(jobs.stream().filter(job -> job
                .getStatus().equals(JobStatus.INVOICE) && job.getDoorToDoor())
                .count());
        summary.setDoorToDoorDeliveredSum(jobs.stream().filter(job -> job.getStatus().equals(JobStatus.INVOICE) && job.getDoorToDoor()).map(calculate_job_cost).mapToDouble(a -> a).sum());

        return summary;
    }

    private final Function<JobDTO, Double> calculate_job_cost = (job) -> job.getLabor() * job.getRate() + job.getParts().stream().map(InventoryItemDTO::getCost).mapToDouble(cost -> cost).sum();

}
