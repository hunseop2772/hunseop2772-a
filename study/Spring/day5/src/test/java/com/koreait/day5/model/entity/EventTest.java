package com.koreait.day5.model.entity;

import com.koreait.day5.model.enumclass.ItemStatus;
import com.koreait.day5.model.enumclass.UserStatus;
import com.koreait.day5.repository.EventRepository;
import com.koreait.day5.repository.ItemRepository;
import com.koreait.day5.repository.PartnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
@SpringBootTest
class EventTest {
    @Autowired
    private EventRepository eventRepository;

    @Test
    public void create(){
        Event event = Event.builder().userId(2l).content("쿠폰").build();
        Event newEvent = eventRepository.save(event);
    }

}