package com.koreait.day8.model.entity;

import com.koreait.day8.model.config.Auditable;
import com.koreait.day8.model.config.BaseEntity;
import com.koreait.day8.model.enumclass.UserStatus;
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
public class Partner extends BaseEntity implements Auditable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String address;
    private String callCenter;
    private String businessNumber;
    private String ceoName;
//    private long categoryId;

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> items;

}
