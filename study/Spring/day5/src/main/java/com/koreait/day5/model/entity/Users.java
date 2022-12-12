package com.koreait.day5.model.entity;


import com.koreait.day5.model.config.Auditable;
import com.koreait.day5.model.config.BaseEntity;
import com.koreait.day5.model.enumclass.UserStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Users extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String name;
    private String userpw;
    private String hp;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
//    private LocalDateTime regDate;
//    private LocalDateTime updateDate;

//    @PrePersist
//    public void prePersist(){
//        this.regDate = LocalDateTime.now();
//        this.updateDate = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updateDate = LocalDateTime.now();
//    }
//}
}