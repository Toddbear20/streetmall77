package streetmall.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import streetmall.config.kafka.KafkaProcessor;
import streetmall.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InventoryRepository inventoryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCompleted'"
    )
    public void wheneverShippingCompleted_DecreseStock(
        @Payload ShippingCompleted shippingCompleted
    ) {
        ShippingCompleted event = shippingCompleted;
        System.out.println(
            "\n\n##### listener DecreseStock : " + shippingCompleted + "\n\n"
        );

        // Sample Logic //
        Inventory.decreseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_DecreseStock(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener DecreseStock : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Inventory.decreseStock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ShippingCancled'"
    )
    public void wheneverShippingCancled_IncreaseStock(
        @Payload ShippingCancled shippingCancled
    ) {
        ShippingCancled event = shippingCancled;
        System.out.println(
            "\n\n##### listener IncreaseStock : " + shippingCancled + "\n\n"
        );

        // Sample Logic //
        Inventory.increaseStock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
