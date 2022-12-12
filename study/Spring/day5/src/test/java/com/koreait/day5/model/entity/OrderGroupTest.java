package com.koreait.day5.model.entity;

import com.koreait.day5.model.enumclass.ItemStatus;
import com.koreait.day5.model.enumclass.OrderType;
import com.koreait.day5.model.enumclass.UserStatus;
import com.koreait.day5.repository.OrderDetailRepository;
import com.koreait.day5.repository.OrderGroupRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderGroupTest {
    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup = OrderGroup.builder().orderType(OrderType.EACH)
                .status("몰라").revAddress("서울"). revName("송").paymentType("카드").build();
        OrderGroup newOrderGroup = orderGroupRepository.save(orderGroup);
    }
}