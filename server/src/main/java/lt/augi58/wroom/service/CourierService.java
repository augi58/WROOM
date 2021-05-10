package lt.augi58.wroom.service;

public interface CourierService {

    boolean createDelivery(String addressFrom, String addressTo); // shipping details

    void finishDelivery(Long jobId);
}
