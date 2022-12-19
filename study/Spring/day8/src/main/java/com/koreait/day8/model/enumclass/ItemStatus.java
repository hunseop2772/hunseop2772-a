package com.koreait.day8.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemStatus {
//enum : 열거체: 미리 지정된 값만 선택가능
    REGISTERED(0, "등록", "상품등록상태"),
    UNREGISTERED(1, "중지", "상품판매 중지상태"),
    WAITING(2, "대기", "상품검수상태");

    private Integer id;
    private String title;
    private String description;
}
