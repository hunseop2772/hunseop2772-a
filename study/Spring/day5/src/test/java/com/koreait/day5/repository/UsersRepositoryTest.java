package com.koreait.day5.repository;

import com.koreait.day5.Day5ApplicationTests;
import com.koreait.day5.model.entity.AdminUser;
import com.koreait.day5.model.entity.Users;
import com.koreait.day5.model.enumclass.UserStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;


public class UsersRepositoryTest extends Day5ApplicationTests {
    @Autowired
     UsersRepository usersRepository;

    @Test
    public void create(){
        Users users = Users.builder().userid("grape1")
                .name("표도").status(UserStatus.REGISTERED).userpw("1234").hp("010-9999-9999")
                .email("grape@grape.com").build();
        Users newUsers = usersRepository.save(users);
    }

    @Test
    public void update(){
        Optional<Users> users = usersRepository.findByUserid("grape");
        users.ifPresent(
                selectUser ->{
                    selectUser.setUserpw("1010");
                    selectUser.setHp("010-1234-1234");
                    usersRepository.save(selectUser);
                }
        );
    }

}
