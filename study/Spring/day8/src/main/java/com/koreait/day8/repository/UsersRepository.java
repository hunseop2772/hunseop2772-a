package com.koreait.day8.repository;

import com.koreait.day8.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findNameByName(String name);      //find...By필드명 => 추상메소드
    Users findByEmail(String email);

    List<Users> getByEmail(String email);
    Set<Users> readByEmail(String email);
    Users queryAppleByEmail(String email);


    List<Users> findFirst3ByName(String name);
    List<Users> findTop10ByName(String name);
    List<Users> findLast3ByName(String name);

    Optional<Users> findByUserid(String userid);

    //and
    List<Users> findByNameAndEmail(String name, String Email);
    //or
    List<Users> findByNameOrEmail(String name, String Email);

    //초과 미만
    List<Users> findByIdAfter(Long id);   // 해당id를 포함하지 않은

    List<Users> findByRegDateAfter(LocalDateTime dateTime);

    //이상:greatThen  이하:lessThen
    List<Users> findByIdGreaterThanEqual(Long id);

    //이하~이상
    List<Users> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Users> findByRegDateIsNull();
    List<Users> findByRegDateIsNotNull();

    List<Users> findByIdBetween(Long id1, Long id2);

    List<Users> findByNameIn(List<String> names);

    List<Users> findByNameStartingWith(String name);
    List<Users> findByNameEndingWith(String name);
    List<Users> findByNameContains(String name);
    List<Users> findByNameLike(String name);    // 퍼센트를 직접 넣어야 한다.



    Optional<Users> findByUseridAndUserpw(String userid, String userpw);    // 퍼센트를 직접 넣어야 한다.

    //정렬
    List<Users> findTopByNameOrderByIdDesc(String name);
    List<Users> findByOrderByIdDesc();
    //2차정렬
    List<Users> findByOrderByIdDescNameAsc();



}

