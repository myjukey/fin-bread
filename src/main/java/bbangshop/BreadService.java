package bbangshop;

import bbangshop.Bread;
import bbangshop.BreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BreadService {
    private final BreadRepository breadRepository;

    @Transactional
    public String checkQuantityByBreadId(String breadId) {

        Optional<Bread> optionalBread = breadRepository.findById(Long.parseLong(breadId));
        Bread bread = optionalBread.orElseGet(Bread::new);
        // 빵이 없을경우 재고0으로 전달
        if(bread.getQuantity() == null) bread.setQuantity(0);
        // 빵 재고 가 있는 경우 재고 -1 하고 할당으로 이벤트 전달
        if( bread.getQuantity() > 0 ){
            bread.setQuantity(bread.getQuantity()-1);
            breadRepository.save(bread);
            //bread.pulishQuantityChecked();
        }
        return bread.getQuantity().toString() ;
    }
}
