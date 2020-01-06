package jpabook.jpashop.api;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  xToOne (ManyToOne, OneToOne)
 * order 조회
 * Order -> Memberd
 * Order -> Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleApiController {

    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> ordersV1(){
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName(); // Lazy 강제 초기화
            order.getDelivery().getAddress();
        }
        //양방향 연관관계에서 엔티티를 직접 노출할때는 한쪽을 @JsonIgnore를 해야 무한루프에 빠지지않음
        //hibernate5Module을 사용하기보다 DTO로 반환해서 사용하는것이 좋은 방법


        return all;
    }
}
