package com.koreait.day5.model.entity;

import com.koreait.day5.model.enumclass.ItemStatus;
import com.koreait.day5.model.enumclass.UserStatus;
import com.koreait.day5.repository.ItemRepository;
import com.koreait.day5.repository.PartnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;
@SpringBootTest
class PartnerTest {
    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        Partner partner = Partner.builder().name("apple").status(UserStatus.REGISTERED).address("서울").build();
        Partner newpartner = partnerRepository.save(partner);
    }

}