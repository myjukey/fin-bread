package bbangshop;

import bbangshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{
    @Autowired BreadRepository breadRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_QuantityChange(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener QuantityChange : " + reservationCanceled.toJson());
            // 취소이벤트 전달받아 재고 원복작업
            Optional<Bread> optionalBread = breadRepository.findById(reservationCanceled.getBreadId());
            Bread bread = optionalBread.orElseGet(Bread::new);
            bread.setQuantity(bread.getQuantity()+1);
            breadRepository.save(bread);
        }
    }

}
