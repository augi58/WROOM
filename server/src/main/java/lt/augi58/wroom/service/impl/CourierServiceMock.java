package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.service.CourierService;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceMock implements CourierService {

    @Override
    public boolean createDelivery(String addressFrom, String addressTo) {
        // MOCK
        // TODO validate order
        if (addressFrom.length() != 0 && addressTo.length() != 0) {
            return true;
        } else return false;
    }

    @Override
    public void finishDelivery(Long jobId) {

    }

}
