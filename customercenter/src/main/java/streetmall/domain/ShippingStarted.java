package streetmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import streetmall.infra.AbstractEvent;

@Data
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private Long orderid;
    private String userid;
    private Long productid;
    private Integer qty;
    private String status;
}
