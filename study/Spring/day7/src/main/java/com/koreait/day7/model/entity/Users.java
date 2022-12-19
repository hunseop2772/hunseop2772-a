package com.koreait.day7.model.entity;

import com.koreait.day7.model.config.Auditable;
import com.koreait.day7.model.config.BaseEntity;
import com.koreait.day7.model.enumclass.UserStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true) //부모것을 가져다 쓴다.
@EqualsAndHashCode(callSuper = true) //부모것을 가져다 쓴다.
@EntityListeners(AuditingEntityListener.class)
public class Users extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

//    private LocalDateTime regDate;

//    @PrePersist
//    public void prePresist(){
//        this.regDate = LocalDateTime.now();
//        this.updateDate= LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updateDate= LocalDateTime.now();
//    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<OrderGroup> orderGroups;



}
