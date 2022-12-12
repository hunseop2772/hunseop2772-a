package com.koreait.day5.model.entity;


import com.koreait.day5.model.config.Auditable;
import com.koreait.day5.model.config.BaseEntity;
import com.koreait.day5.model.enumclass.OrderType;
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
public class OrderGroup  extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private LocalDateTime arrivalDate;
    private String status;
    private String revAddress;
    private String revName;
    private String paymentType;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private Long userId;
}
