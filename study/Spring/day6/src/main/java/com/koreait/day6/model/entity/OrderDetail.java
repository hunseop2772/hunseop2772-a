package com.koreait.day6.model.entity;


import com.koreait.day6.model.config.Auditable;
import com.koreait.day6.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // 연속적으로 실행하게 해주는 기능 ex) method.method ......
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime arrivalDate;
    private String status;
    private Integer quantity;
    private BigDecimal totalPrice;
//    private LocalDateTime regDate;
//    private Long itemId;
//    private Long orderGroupId;

    @ManyToOne
    private Item item;

    @ManyToOne
    private OrderGroup orderGroup;
}
