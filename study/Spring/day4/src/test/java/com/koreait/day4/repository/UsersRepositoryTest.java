package com.koreait.day4.repository;

import com.koreait.day4.Day4ApplicationTests;
import com.koreait.day4.model.entity.Users;
import com.koreait.day4.model.enumclass.UserStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public class UsersRepositoryTest extends Day4ApplicationTests {
    @Autowired
     UsersRepository usersRepository;

    @Test
    public void create(){
        Users users = Users.builder().userid("cherry").name("체에리")
                .userpw("5555").hp("010-5555-5555").email("cherry@cherry.com")
                .status(UserStatus.REGISTERED).build();
        usersRepository.save(users);
    }

    @Test
    public void read(){
        System.out.println(usersRepository.findNameByName("김사과"));
        System.out.println(usersRepository.findByEmail("banana@banana.com"));
        System.out.println(usersRepository.getByEmail("orange@orange.com"));
        System.out.println(usersRepository.readByEmail("bery@bery.com"));

        System.out.println(usersRepository.queryAppleByEmail("mango@mango.com"));

        System.out.println(usersRepository.findFirst3ByName("김사과"));
        System.out.println(usersRepository.findTop10ByName("김사과"));
        System.out.println(usersRepository.findLast3ByName("김사과"));

        System.out.println(usersRepository.findByNameAndEmail("송사과", "apple@naver.com"));
        System.out.println(usersRepository.findByNameOrEmail("송사과", "banana@banana.com"));
        System.out.println(usersRepository.findByIdAfter(2l));
        System.out.println(usersRepository.findByRegDateAfter(LocalDateTime.now())); // 사간 계산
        System.out.println(usersRepository.findByRegDateBefore(LocalDateTime.now())); // 전날
        System.out.println(usersRepository.findByRegDateAfter(LocalDateTime.now().minusDays(2L))); // 날포함한 전날
        System.out.println(usersRepository.findByIdGreaterThanEqual(2l));
        System.out.println(usersRepository.findByIdGreaterThanEqualAndIdLessThanEqual(2l,5l)); //2이상 5이하
        System.out.println(usersRepository.findByIdBetween(2l,5l));


        System.out.println(usersRepository.findByRegDateIsNull());
        System.out.println(usersRepository.findByRegDateIsNotNull());

        System.out.println(usersRepository.findByNameIn(Lists.newArrayList("반하나","체에리")));
        System.out.println(usersRepository.findByNameStartingWith("송"));
        System.out.println(usersRepository.findByNameEndingWith("과"));
        System.out.println(usersRepository.findByNameContains("사"));

        System.out.println(usersRepository.findByNameLike("%하%"));

        System.out.println(usersRepository.findTopByNameOrderByIdDesc("송사과"));
        System.out.println(usersRepository.findByOrderByIdDesc());
        System.out.println(usersRepository.findByOrderByIdDescNameAsc());




    }
    @Test
    public void selectUserid(){
        //아이디로 검색하는 록직
        Optional<Users> users = usersRepository.findByUserid("apple");
        users.ifPresent(
                selectUser ->{
                    System.out.println("userid : " +selectUser.getUserid());
                    System.out.println("userid : " +selectUser.getName());
                    System.out.println("userid : " +selectUser.getHp());
                    System.out.println("userid : " +selectUser.getEmail());
                }
        );
    }

    @Test
    public void updateUserid(){
        //아이디를 통해 데이터를 변경
        Optional<Users> users = usersRepository.findByUserid("apple");
        users.ifPresent(
                selectUser ->{
                    selectUser.setEmail("apple@naver.com");
                    selectUser.setHp("010-1000-1000");
                    selectUser.setName("송사과");
                    selectUser.setUpdateDate(LocalDateTime.now());
                    usersRepository.save(selectUser);
                }
        );
    }

    @Test
    public void deleteUserid(){
        //아이디를 통해 데이터를 삭제
        Optional<Users> users = usersRepository.findByUserid("orange");
        users.ifPresent(
                selectUser ->{
                    usersRepository.delete(selectUser);
                }
        );
    }

    @Test
    public void login(){
        //userid , hp, email

        Optional<Users> users = usersRepository.findByUseridAndUserpw("apple","2222");
        users.ifPresent(
                selectUser ->{
                    System.out.println("userid : " +selectUser.getUserid());
                    System.out.println("hp : " +selectUser.getHp());
                    System.out.println("email : " +selectUser.getEmail());
                }
        );


    }

}
