package com.koreait.day8.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Header<T> {
    private LocalDateTime transactionTime;
    private String resultCode;
    private T data;
    private String description;

    public static <T> Header<T> Ok(){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("Ok").description("정상").build();

    }

    public static <T> Header<T> Ok(T data){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("Ok").description("정상").data(data).build();

    }

    public static <T> Header<T> ERROR(String description){
        return (Header<T>) Header.builder().transactionTime(LocalDateTime.now()).resultCode("ERROR").description("에러!").build();

    }

}
