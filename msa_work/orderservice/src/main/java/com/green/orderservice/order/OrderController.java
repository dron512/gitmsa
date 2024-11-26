package com.green.orderservice.order;

import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 해당하는 사용자 주문하기
    @PostMapping("/{userId}/order")
    public ResponseEntity<OrderResponse> userOrder(@PathVariable Long userId,
                                                   @RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.order(userId, orderRequest);
        return ResponseEntity.ok(orderResponse);
    }

    // 해당하는 사용자 주문목록보기


}
