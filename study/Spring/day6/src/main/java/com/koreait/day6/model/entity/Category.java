package com.koreait.day6.model.entity;

import com.koreait.day6.model.config.Auditable;
import com.koreait.day6.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity // JPA를 사용해서 DB 테이블과 메핑할 클래스를 연결
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만들어줌
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Category extends BaseEntity implements Auditable { // ctrl + shift + t
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String title;
    private String updateBy;
// Category : partner (1:N)

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    // lazy가 대부분에서 사용된다. 쓸데없는 다른 모든 객체를 가저올 필요가 없다
    // Eager 아무것도 사용하지 않으면 기본으로 사용되고 모든 데이터를 가저오는 것이다.

    private List<Partner> partners;
    // category 파일에 선언하였다 partner을 @OneToMany 형으로.





}
//    @CreatedDate // 인서트시 자동으로 데이터를 넣어준다.
//    private LocalDateTime regDate;


//    @LastModifiedDate // 수정 시 날자를 넣어준다
//    private LocalDateTime updateDate;
