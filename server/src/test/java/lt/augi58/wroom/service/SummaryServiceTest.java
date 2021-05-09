package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.domain.SummaryDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SummaryServiceTest extends BaseTest {
    @Autowired
    SummaryService summaryService;

    @Test
    void getSummaryDoorToDoorEstimates() {
        var summary = givenSummary();

        Assert.assertEquals(
                summaryService.getSummary().getDoorToDoorEstimatesOrders(),
                summary.getDoorToDoorEstimatesOrders()
        );
        ;
    }

    private SummaryDTO givenSummary() {
        var summary = new SummaryDTO();

        summary.setDoorToDoorDeliveredOrders(31L);
        summary.setDoorToDoorDeliveredSum(300D);
        summary.setDoorToDoorEstimatesOrders(40L);
        summary.setDoorToDoorEstimatesSum(350D);
        summary.setDoorToDoorInProgressOrders(12L);
        summary.setDoorToDoorInProgressSum(300D);
        summary.setDoorToDoorDeliveredSum(12D);
        summary.setEstimatesOrders(20L);
        summary.setEstimatesSum(25D);
        summary.setEstimatesSum(30D);
        summary.setDroppedOffOrders(29L);
        summary.setDroppedOffSum(19D);
        summary.setInProgressOrders(20L);
        summary.setInProgressSum(50D);
        summary.setInvoicesOrders(12L);
        summary.setInvoicesSum(99D);
        summary.setTotalOrders(22L);
        summary.setTotalSum(40D);

        return summaryService.getSummary();

    }
}
