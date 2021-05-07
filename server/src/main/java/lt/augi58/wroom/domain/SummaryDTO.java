package lt.augi58.wroom.domain;

public class SummaryDTO {

    private Long estimatesOrders;
    private Double estimatesSum;
    private Long droppedOffOrders;
    private Double droppedOffSum;
    private Long inProgressOrders;
    private Double inProgressSum;
    private Long invoicesOrders;
    private Double invoicesSum;
    private Long totalOrders;
    private Double totalSum;

    private Long doorToDoorEstimatesOrders;
    private Double doorToDoorEstimatesSum;
    private Long doorToDoorInProgressOrders;
    private Double doorToDoorInProgressSum;
    private Long doorToDoorDeliveredOrders;
    private Double doorToDoorDeliveredSum;

    public Long getEstimatesOrders() {
        return estimatesOrders;
    }

    public void setEstimatesOrders(Long estimatesOrders) {
        this.estimatesOrders = estimatesOrders;
    }

    public Double getEstimatesSum() {
        return estimatesSum;
    }

    public void setEstimatesSum(Double estimatesSum) {
        this.estimatesSum = estimatesSum;
    }

    public Long getDroppedOffOrders() {
        return droppedOffOrders;
    }

    public void setDroppedOffOrders(Long droppedOffOrders) {
        this.droppedOffOrders = droppedOffOrders;
    }

    public Double getDroppedOffSum() {
        return droppedOffSum;
    }

    public void setDroppedOffSum(Double droppedOffSum) {
        this.droppedOffSum = droppedOffSum;
    }

    public Long getInProgressOrders() {
        return inProgressOrders;
    }

    public void setInProgressOrders(Long inProgressOrders) {
        this.inProgressOrders = inProgressOrders;
    }

    public Double getInProgressSum() {
        return inProgressSum;
    }

    public void setInProgressSum(Double inProgressSum) {
        this.inProgressSum = inProgressSum;
    }

    public Long getInvoicesOrders() {
        return invoicesOrders;
    }

    public void setInvoicesOrders(Long invoicesOrders) {
        this.invoicesOrders = invoicesOrders;
    }

    public Double getInvoicesSum() {
        return invoicesSum;
    }

    public void setInvoicesSum(Double invoicesSum) {
        this.invoicesSum = invoicesSum;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getDoorToDoorEstimatesOrders() {
        return doorToDoorEstimatesOrders;
    }

    public void setDoorToDoorEstimatesOrders(Long doorToDoorEstimatesOrders) {
        this.doorToDoorEstimatesOrders = doorToDoorEstimatesOrders;
    }

    public Double getDoorToDoorEstimatesSum() {
        return doorToDoorEstimatesSum;
    }

    public void setDoorToDoorEstimatesSum(Double doorToDoorEstimatesSum) {
        this.doorToDoorEstimatesSum = doorToDoorEstimatesSum;
    }

    public Long getDoorToDoorInProgressOrders() {
        return doorToDoorInProgressOrders;
    }

    public void setDoorToDoorInProgressOrders(Long doorToDoorInProgressOrders) {
        this.doorToDoorInProgressOrders = doorToDoorInProgressOrders;
    }

    public Double getDoorToDoorInProgressSum() {
        return doorToDoorInProgressSum;
    }

    public void setDoorToDoorInProgressSum(Double doorToDoorInProgressSum) {
        this.doorToDoorInProgressSum = doorToDoorInProgressSum;
    }

    public Long getDoorToDoorDeliveredOrders() {
        return doorToDoorDeliveredOrders;
    }

    public void setDoorToDoorDeliveredOrders(Long doorToDoorDeliveredOrders) {
        this.doorToDoorDeliveredOrders = doorToDoorDeliveredOrders;
    }

    public Double getDoorToDoorDeliveredSum() {
        return doorToDoorDeliveredSum;
    }

    public void setDoorToDoorDeliveredSum(Double doorToDoorDeliveredSum) {
        this.doorToDoorDeliveredSum = doorToDoorDeliveredSum;
    }
}
