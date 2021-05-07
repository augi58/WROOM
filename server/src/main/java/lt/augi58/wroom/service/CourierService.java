package lt.augi58.wroom.service;

public interface CourierService {

    void createDelivery(String addressFrom, String addressTo); // shipping details

    void finishDelivery(Long jobId);
}
