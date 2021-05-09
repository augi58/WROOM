package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.service.impl.CourierServiceMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CourierServiceTest extends BaseTest {

    @Autowired

    @Test
    void createDelivery() {
        var courier = new CourierServiceMock();
        //TODO: Void method - for future

        courier.createDelivery("Vilnius", "Kaunas");
    }

    @Test
    void finishDelivery() {
        var courier = new CourierServiceMock();
        //TODO: Void method - for future

        courier.finishDelivery(12345L);

    }

}