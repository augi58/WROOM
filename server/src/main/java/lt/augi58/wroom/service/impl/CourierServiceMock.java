package lt.augi58.wroom.service.impl;

import lt.augi58.wroom.service.CourierService;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceMock implements CourierService {

    @Override
    public void createDelivery(String addressFrom, String addressTo) {

    }

    @Override
    public void finishDelivery(Long jobId) {

    }

}
