package com.koreait.day5.model.entity;

import com.koreait.day5.model.enumclass.ItemStatus;
import com.koreait.day5.repository.OrderDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderDetailTest {
@Autowired
    private OrderDetailRepository orderDetailRepository;

@Test
    public void create(){
    OrderDetail orderDetail = OrderDetail.builder().status("결제완료")
            .quantity(1).totalPrice(BigDecimal.valueOf(200000))
            .itemId(1l).build();
    OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
}
}