package com.koreait.day6.model.network.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserApiRequest {
    //클라이언트가 서버쪽으로 요청할 정보를 전달해주는 부분
    private String userid;
    private String name;
    private String userpw;
    private String hp;
    private String email;



}
