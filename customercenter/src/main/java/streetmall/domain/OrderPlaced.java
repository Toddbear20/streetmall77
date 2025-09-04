package streetmall.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import streetmall.infra.AbstractEvent;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userid;
    private Long productid;
    private Integer qty;
    private String status;
    private String adress;
}
