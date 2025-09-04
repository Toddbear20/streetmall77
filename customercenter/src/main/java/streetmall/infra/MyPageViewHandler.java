package streetmall.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import streetmall.config.kafka.KafkaProcessor;
import streetmall.domain.*;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setOrderid(String.valueOf(orderPlaced.getId()));
            myPage.setUserid(orderPlaced.getUserid());
            myPage.setProductid(orderPlaced.getProductid());
            myPage.setStatus(orderPlaced.getStatus());
            myPage.setQty(orderPlaced.getQty());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenShippingStarted_then_UPDATE_1(
        @Payload ShippingStarted shippingStarted
    ) {
        try {
            if (!shippingStarted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderid(
                String.valueOf(shippingStarted.getOrderid())
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(shippingStarted.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenShippingCompleted_then_UPDATE_2(
        @Payload ShippingCompleted shippingCompleted
    ) {
        try {
            if (!shippingCompleted.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByOrderid(
                String.valueOf(shippingCompleted.getOrderid())
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(shippingCompleted.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
