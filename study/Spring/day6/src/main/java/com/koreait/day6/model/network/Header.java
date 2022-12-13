package com.koreait.day6.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Header<T> {
    private LocalDateTime transactionTime;
    private String resultCode;
    private  T data;//리스폰스,리퀘스트 값 전달?
    private String description;

    /* T data
        json
        {
        transactionTime : 현재시간,
        resultCode : 200,
        data : {
            userid : "apple",
            ....
            }
        description : "정상"
         */


    public static <T> Header<T> Ok(){ // 다른 곳에서 ok라는 메소드를 사용(호출)하면
        //헤더 객체를 만들고 밑에 있는 내용들을 넣어주는 것을 만들고 리턴하라는  내용이다.
        // 클라이언트가 페이지 보여줘 라고 하면 정보 담을게 없으면 응답만 하기에 사용되는 내용이다
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ok").description("정상").build();
    }

    private  static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ok").description("정상").data(data).build();
    }
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder().transactionTime(LocalDateTime.now())
                .resultCode("ERROR").description("에러!").build();
    }
}
