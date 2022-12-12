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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
public class AdminUser extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String userpw;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    // 레지스테이터스나 언레지스테이터스만 들어갈 수 있음
    private LocalDateTime lastLoginAt;
//    private String regDate;

    @PostLoad
    public void postLoad(){
        System.out.println("PostLoad!");
    }
    @PrePersist
    public void prePersist(){
        System.out.println("PrePersist!");
    }
    @PreUpdate
    public void preUpdate(){
        System.out.println("PreUpdate!");
    }
    @PreRemove
    public void preRemove(){
        System.out.println("PreRemove!");
    }
    @PostPersist
    public void postPersist(){
        System.out.println("PostPersist!");
    }
    @PostUpdate
    public void postUpdate(){
        System.out.println("PostUpdate!");
    }
    @PostRemove
    public void postRemove(){
        System.out.println("PostRemove!");
    }
}
