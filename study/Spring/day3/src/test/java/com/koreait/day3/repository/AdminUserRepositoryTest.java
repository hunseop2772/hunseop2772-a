package com.koreait.day3.repository;

import com.koreait.day3.Day3ApplicationTests;
import com.koreait.day3.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class AdminUserRepositoryTest extends Day3ApplicationTests {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        // @Builder를 사용하여 하위 부분을 사용할 수 있다.
        AdminUser adminUser = AdminUser.builder().userid("banana")
                .userpw("2222").name("반하나").build();
        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        //set한 내용 adminUser을 save에 넣기

//        Hibernate: insert into admin_user (last_login_at, name,
//            reg_date, status, userid, userpw) values (?, ?, ?, ?, ?, ?)


//        AdminUser adminUser = new AdminUser();
//        adminUser.setUserid("aplle");
//        adminUser.setUserpw("1234");
//        adminUser.setName("김사과");
//        AdminUser newAdminUser = adminUserRepository.save(adminUser);

    }
    @Test
    public void update() {
        // sql ->  findById() : id로 select해달라
        Optional<AdminUser> adminUser = adminUserRepository.findById(1l);
        adminUser.ifPresent(
            selectUsers -> {
                selectUsers.setUserpw("1004");
                selectUsers.setLastLoginAt(LocalDateTime.now());// 현제시간
                selectUsers.setName("사과킴");
                adminUserRepository.save(selectUsers);
            }
        );
    }
    @Test
    public void delete(){
            Optional<AdminUser> adminUser = adminUserRepository.findById(1l);
            adminUser.ifPresent(
                    selectUsers ->{
                        adminUserRepository.delete(selectUsers);
                    }
            );
    }
}
