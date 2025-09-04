package streetmall.domain;

import java.util.*;
import lombok.*;
import streetmall.domain.*;
import streetmall.infra.AbstractEvent;

@Data
@ToString
public class OrderCancled extends AbstractEvent {

    private Long id;
}
