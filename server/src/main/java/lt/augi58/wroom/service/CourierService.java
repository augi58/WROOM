package lt.augi58.wroom.service;

public interface CourierService {

    void createDelivery(); // shipping details

    void finishDelivery(Long jobId);
}
