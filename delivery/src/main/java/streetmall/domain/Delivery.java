package streetmall.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import streetmall.DeliveryApplication;
import streetmall.domain.ShippingCancled;
import streetmall.domain.ShippingCompleted;
import streetmall.domain.ShippingStarted;

@Entity
@Table(name = "Delivery_table")
@Data
//<<< DDD / Aggregate Root
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderid;

    private String userid;

    private Long productid;

    private Integer qty;

    private String status;

    @PostUpdate
    public void onPostUpdate() {
        ShippingCompleted shippingCompleted = new ShippingCompleted(this);
        shippingCompleted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void startShip(OrderPlaced orderPlaced) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        ShippingStarted shippingStarted = new ShippingStarted(delivery);
        shippingStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderPlaced.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            ShippingStarted shippingStarted = new ShippingStarted(delivery);
            shippingStarted.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancleShip(OrderCancled orderCancled) {
        //implement business logic here:

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        ShippingCancled shippingCancled = new ShippingCancled(delivery);
        shippingCancled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(orderCancled.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            ShippingCancled shippingCancled = new ShippingCancled(delivery);
            shippingCancled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
