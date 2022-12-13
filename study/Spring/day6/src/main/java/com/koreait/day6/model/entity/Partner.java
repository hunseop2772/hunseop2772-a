package com.koreait.day6.model.entity;


import com.koreait.day6.model.config.Auditable;
import com.koreait.day6.model.config.BaseEntity;
import com.koreait.day6.model.enumclass.UserStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
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
//    private LocalDateTime regDate;
//    private LocalDateTime updateDate;
//    private Long categoryId;

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> items;

}
