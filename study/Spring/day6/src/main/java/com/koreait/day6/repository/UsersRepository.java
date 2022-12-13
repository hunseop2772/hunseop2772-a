
package com.koreait.day6.repository;


import com.koreait.day6.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findNameByName(String name); // find...By필드명,  메소드 생성
    Users findByEmail(String email);
    List<Users> getByEmail(String email);
    Set<Users> readByEmail(String email); // List와 유사하나 Set은 중복을 배제하고 정해진 순서는 없다
    Users queryAppleByEmail(String email);

    List<Users> findFirst3ByName(String name);
    List<Users> findTop10ByName(String name);
    List<Users> findLast3ByName(String name);

    Optional<Users> findByUserid(String userid);

    List<Users> findByNameAndEmail(String name, String email);
    List<Users> findByNameOrEmail(String name, String email);

    List<Users> findByIdAfter(Long id);//해당 아이디를 포함하지 않음
    List<Users> findByRegDateAfter(LocalDateTime dateTime);
    List<Users> findByRegDateBefore(LocalDateTime dateTime);
    List<Users> findByIdGreaterThanEqual(Long id); // ~이상, 해당 id를 포함
    List<Users> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);
    List<Users> findByIdBetween(Long id1, Long id2);


    List<Users> findByRegDateIsNull();
    List<Users> findByRegDateIsNotNull();


    List<Users> findByNameIn(List<String> names);
    List<Users> findByNameStartingWith(String name);// 시작
    List<Users> findByNameEndingWith(String name);//끝
    List<Users> findByNameContains(String name);//포한하는 글자
    List<Users> findByNameLike(String name);

    Optional<Users> findByUseridAndUserpw(String userid, String userpw);
    List<Users> findTopByNameOrderByIdDesc(String name);// 이름 내림차순
    List<Users> findByOrderByIdDesc();
    List<Users> findByOrderByIdDescNameAsc();
}
