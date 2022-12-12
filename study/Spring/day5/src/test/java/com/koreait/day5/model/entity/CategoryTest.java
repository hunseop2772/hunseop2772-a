package com.koreait.day5.model.entity;

import com.koreait.day5.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        Category category = Category.builder().type("사용 중").title("뷰티").build();
        Category newCategory = categoryRepository.save(category);
    }

    @Test
    public void update(){
        Optional<Category> category = categoryRepository.findById(2l);
        category.ifPresent(
                selectCategory ->{
                    selectCategory.setType("중지");
                    categoryRepository.save(selectCategory);
                }
        );
    }

}