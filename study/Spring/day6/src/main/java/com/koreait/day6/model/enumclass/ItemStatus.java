package com.koreait.day6.model.enumclass;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {
    REGISTERED(0,"등록","상품 등록상태"),
    UNREGISTERED(1,"중지","중지 등록상태"),
    WAITING(2,"대가","상품 검수상태");

    private  Integer id;
    private  String title;
    private  String description;

}
