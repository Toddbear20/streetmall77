package streetmall.domain;

import java.util.*;
import lombok.*;
import streetmall.domain.*;
import streetmall.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userid;
    private Long productid;
    private Integer qty;
    private String status;
}
