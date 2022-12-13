package com.koreait.day6.model.entity;


import com.koreait.day6.model.config.Auditable;
import com.koreait.day6.model.config.BaseEntity;
import com.koreait.day6.model.enumclass.OrderType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity // JPA를 사용해서 DB 테이블과 매핑할 클래스는 @Entity를 꼭 붙여야만 매핑이 가능합니다.
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
//    private Long userId;
    //주문테이블 - orderGroup

    @JoinColumn(name="user_id")
    @ManyToOne
    private Users users;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetails;
}
