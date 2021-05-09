package lt.augi58.wroom.service;

import lt.augi58.wroom.BaseTest;
import lt.augi58.wroom.service.impl.CourierServiceMock;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CourierServiceTest extends BaseTest {

    @Test
    void createDelivery() {
        var courier = new CourierServiceMock();
        courier.createDelivery("Vilnius", "Kaunas");
    }

    @Test
    void finishDelivery() {
        var courier = new CourierServiceMock();
        courier.finishDelivery(12345L);

    }

}