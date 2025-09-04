package streetmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetmall.domain.*;
import streetmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String userid;
    private Long productid;
    private Integer qty;
    private String status;

    public ShippingStarted(Delivery aggregate) {
        super(aggregate);
    }

    public ShippingStarted() {
        super();
    }
}
//>>> DDD / Domain Event
