package com.koreait.day6.model.entity;

import com.koreait.day6.model.config.Auditable;
import com.koreait.day6.model.config.BaseEntity;
import com.koreait.day6.model.enumclass.ItemStatus;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class Item extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ItemStatus status; // enum class의 itemStatus 내용만 들어갈 수 있음
    private String title;
    private String content;
    private BigDecimal price;
//    private LocalDateTime regDate;
    private String createBy;
//    private LocalDateTime updateDate;
    private String updateBy;
//    private Long partnerId;

    @ManyToOne
    private Partner partner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetails;

}
