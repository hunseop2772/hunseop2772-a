package com.koreait.day8.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderType {
    ALL(0, "묶음", "모든 상품을 묶어서 배송"),
    Each(1, "개발", "모든 상품을 각각 준비되는 대로 발송");

    private Integer id;
    private String title;
    private String description;
}
