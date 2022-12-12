package com.koreait.day5.repository;

import com.koreait.day5.Day5ApplicationTests;
import com.koreait.day5.model.entity.AdminUser;
import com.koreait.day5.model.enumclass.UserStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AdminUserRepositoryTest extends Day5ApplicationTests {
    @Autowired //  메서드가 자동으로 호출되고, 인스턴스가 자동으로 주입 ,

    private AdminUserRepository adminUserRepository;

    @Test
    public void delete(){
        Optional<AdminUser> adminUser = adminUserRepository.findByUserid("apple");
        adminUser.ifPresent(
                selectUser -> {
                    adminUserRepository.delete(selectUser);
                }
        );
    }

    @Test
    public void create(){
        AdminUser adminUser = AdminUser.builder().userid("song1").userpw("0000")
                .name("쏭").build();
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
    }

    @Test
    public void update(){
        Optional<AdminUser> adminUser = adminUserRepository.findByUserid("apple");
        adminUser.ifPresent(
                selectUser ->{
                    selectUser.setUserpw("1010");
                    selectUser.setLastLoginAt(LocalDateTime.now());
                    adminUserRepository.save(selectUser);
                }
        );
    }

}
