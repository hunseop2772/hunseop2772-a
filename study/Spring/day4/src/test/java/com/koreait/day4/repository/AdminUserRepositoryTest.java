package com.koreait.day4.repository;

import com.koreait.day4.Day4ApplicationTests;
import com.koreait.day4.model.entity.AdminUser;
import com.koreait.day4.model.enumclass.UserStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdminUserRepositoryTest extends Day4ApplicationTests {
    @Autowired //  메서드가 자동으로 호출되고, 인스턴스가 자동으로 주입 ,
    // 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념
    private AdminUserRepository adminUserRepository;
    //
    // findById() 리터널이 optional
    @Test
    public void crud1(){// 모든 데이터 출력
//        adminUserRepository.findAll().forEach(System.out::println);
        //findAll() 모든 내용을 가저온다
        //forEach() 해당 내용을 반복하는 기능
        // System.out::println ->  람다식에서 나온 문법, toString을 해주게 된다.
        // 내가 입력한 내용을 모두 출력해준다고 생각하면 된다.
        // 데이터기 많으면 부하가 발생할 수 있다.
//        for(AdminUser adminUser : adminUserRepository.findAll()){
//            System.out.println(adminUser); //위와 동일하다.
//        }
        List<AdminUser> adminUsers = adminUserRepository.findAll();// list에 담아서 사용하기
        adminUsers.forEach(System.out::println); //  위 2개 모두 동일하다

    }

    // 데이터 정렬하기
    @Test
    public void crud2(){
        //Sort 클래스 .by (~에 의해) Sort.Direction 방향을 정렬하여 Desc 내림차순하고 , id(어떤걸 기준으로 할지까지 정해주기)
        List<AdminUser> adminUsers = adminUserRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
        adminUsers.forEach(System.out::println);
    }

    @Test
    // 데이터 검색하기
    public void crud3(){
//        List<Long> ids = new ArrayList<>();
//        ids.add(3l);
//        ids.add(5l);
//        ids.add(6l);
//        List<AdminUser> adminUsers = adminUserRepository.findAllById(ids);
        //findAllById(변수) 변수를 해당하는것을 모두 찾는다.

        List<AdminUser> adminUsers = adminUserRepository.findAllById(Lists.newArrayList(3l,5l,6l));
        // 따로 Array리스트랑 변수를 추가할 필요없이 내부에 코드를 입력하여 동일한 결과를 출력할 수 있다.
        adminUsers.forEach(System.out::println);
    }
    // 여러 데이터 저장
    @Test
    public void  crud4(){
        AdminUser adminUser1 = AdminUser.builder().userid("song2772")
                .userpw("2772").name("송이").build();
        AdminUser adminUser2 = AdminUser.builder().userid("mango")
                .userpw("8888").name("마앙고").build();

        adminUserRepository.saveAll(Lists.newArrayList(adminUser1,adminUser2));
        List<AdminUser> adminUsers = adminUserRepository.findAll();
        adminUsers.forEach(System.out::println);
    }

    // 데이터 불러오기1
    @Test
    @Transactional
    public void crud5(){
        AdminUser adminUser = adminUserRepository.getOne(3l);
        //getOne = findById 와 동일하게 ID를 기반으로 찾는다
        //getOne은 단일 작업으로 생각하지 않고
        System.out.println(adminUser);
    }

    // 데이터 불러오기2
    @Test
    public void crud6() {
       // Optional<AdminUser> adminUser = adminUserRepository.findById(3l); 기존 불러오는 방식은 optional을 사용
      AdminUser adminUser = adminUserRepository.findById(3l).orElseThrow(); // null이 아닐경우
        System.out.println(adminUser);
    }

    // 데이터 개수 불러오기
    @Test
    public void crud7(){
        long count = adminUserRepository.count();
        System.out.println(count);
    }

    // 아이디 존재 유무확인
    @Test
    public void crud8(){
        boolean exists = adminUserRepository.existsById(3l);
        //existsById(3l) : 존재하는지 있으면 -> true이고 count를 확인하기 때문에
        // 전체를 불러오는것은 데이터 효율적으로 좋지 않다
        System.out.println(exists);
    }

    //데이터 삭제
    @Test
    public void crud9(){
//      adminUserRepository.deleteById(16l);

        adminUserRepository.delete(adminUserRepository.findById(7l).orElseThrow(RuntimeException::new));
        adminUserRepository.findAll().forEach(System.out::println);
    }

    //여러 데이터 삭제
    @Test
    public void crud10(){
        //데이터 삭제시 select가 각각 일어남
//        adminUserRepository.deleteAll(adminUserRepository.findAllById(Lists.newArrayList(5l,9l)));
        adminUserRepository.deleteAllInBatch(adminUserRepository.findAllById(Lists.newArrayList(5l, 9l)));
        adminUserRepository.findAll().forEach(System.out::println);
    }

    // 페이지 생성
    @Test
    public void crud11(){
        //import org.springframework.data.domain.Page; 확인!
        Page<AdminUser> adminUsers = adminUserRepository.findAll(PageRequest.of(0,3));
        System.out.println("🐔 page :" + adminUsers);
        //Page 2 of 4 containing com.koreait.day4.model.entity.AdminUser instances
        System.out.println("🐔 totalElements :" + adminUsers.getTotalElements());
        // 등록된 사람(게시물) 수를 출력
        System.out.println("🐔 totalPages :" + adminUsers.getTotalPages()); // page수
        System.out.println("🐔 numberOfElements :" + adminUsers.getNumberOfElements());
        // 해당 페이지에 몇개씩 있는지
        System.out.println("🐔 size :" + adminUsers.getSize());
        // 남은 사이즈를 확인 내가 보고있는 페이지는 0이기 때문에 size :3
        System.out.println("🐔 sort :" + adminUsers.getSort());
        adminUsers.getContent().forEach(System.out::println);
    }

    @Test
    public void  create(){
        AdminUser adminUser = AdminUser.builder().userid("grape")
                .userpw("3422").name("포오도")
                .status(UserStatus.REGISTERED)
                .build();
        adminUserRepository.save(adminUser);

    }

}
