package com.koreait.day7.model.entity;

import com.koreait.day7.model.config.Auditable;
import com.koreait.day7.model.config.BaseEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true) //부모것을 가져다 쓴다.
@EqualsAndHashCode(callSuper = true) //부모것을 가져다 쓴다.
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime arrivalDate;
    private String status;
    private String quantity;
    private BigDecimal totalPrice;
//    private Long itemId;
//    private Long orderGroupId;


    @ManyToOne
    private Item item;

    @ManyToOne
    private OrderGroup orderGroup;

}
