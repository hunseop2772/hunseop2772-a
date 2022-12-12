package com.koreait.day5.model.entity;

import com.koreait.day5.model.config.Auditable;
import com.koreait.day5.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // JPA를 사용해서 DB 테이블과 메핑할 클래스를 연결
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만들어줌
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Event extends BaseEntity implements  Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String content;

}
