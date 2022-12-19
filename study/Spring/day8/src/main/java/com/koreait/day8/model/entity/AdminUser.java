package com.koreait.day8.model.entity;

import com.koreait.day8.model.config.Auditable;
import com.koreait.day8.model.config.BaseEntity;
import com.koreait.day8.model.enumclass.UserStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Table(name="admin_user")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true) //부모것을 가져다 쓴다.
@EqualsAndHashCode(callSuper = true) //부모것을 가져다 쓴다.
@EntityListeners(AuditingEntityListener.class)
public class AdminUser extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String userpw;
    private String name;
    @Enumerated(EnumType.STRING)    //엉뚱한 값이 들어가지 않도록 함
    private UserStatus status;
    private LocalDateTime lastLoginAt;

    @PostLoad       // 엔티티가 영속성 컨텍스트에 조회된 직후
    public void postLoad(){
        System.out.println("PostLoad!됨");
    }

    @PrePersist       // 새로운 인스턴스를 merge할 때 수행된다. presist() 메소드를 호출해서 엔티티를 영속성 컨테스트에 관리하기 직전에 호출
    public void prePersist(){
        System.out.println("PrePersist!됨");
    }

    @PreUpdate       // flush, commit를 호출해서 엔티티를 데이터베이스에 수정하기 직전에 호출
    public void preUpdate(){
        System.out.println("PreUpdate!됨");
    }

    @PreRemove       // remove 메소드를 호출해서 엔티티를 영속성 컨텍스트에서 삭제하기 직전에 호출
    public void preRemove (){
        System.out.println("PreRemove !됨");
    }

    @PostPersist       // flush, commit를 호출해서 엔티티를 데이터베이스에 저장한 직후에 호출
    public void postPersist(){
        System.out.println("PostPersist!됨");
    }


    @PostUpdate       // flush, commit를 호출해서 엔티티를 데이터베이스에 수정한 직후에 호출
    public void postUpdate(){
        System.out.println("PostUpdate!됨");
    }


    @PostRemove      // remove 메소드를 호출해서 엔티티를 영속성 컨텍스트에서 삭제한 직후에 호출
    public void postRemove(){
        System.out.println("PostRemove!됨");
    }


}
