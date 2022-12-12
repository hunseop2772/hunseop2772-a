package com.koreait.day5.model.entity;

import com.koreait.day5.model.enumclass.ItemStatus;
import com.koreait.day5.repository.CategoryRepository;
import com.koreait.day5.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
@SpringBootTest
class ItemTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = Item.builder().name("사용 중").status(ItemStatus.REGISTERED).title("뷰티").content("예뻐요").build();
        Item newItem = itemRepository.save(item);
    }

}