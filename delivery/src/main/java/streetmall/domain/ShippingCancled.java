package streetmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import streetmall.domain.*;
import streetmall.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ShippingCancled extends AbstractEvent {

    private Long id;

    public ShippingCancled(Delivery aggregate) {
        super(aggregate);
    }

    public ShippingCancled() {
        super();
    }
}
//>>> DDD / Domain Event
