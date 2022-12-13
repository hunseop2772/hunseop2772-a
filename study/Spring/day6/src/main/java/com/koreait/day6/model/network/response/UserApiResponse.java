package com.koreait.day6.model.network.response;

import com.koreait.day6.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {
    //서버가 사용자에게 줄 수 있는 데이터 들을 클레스 화
    private Long id;
    private String userid;
    private String name;
    private String userpw;
    private String hp;
    private String email;
    private LocalDateTime regDate;
    private UserStatus status;

}
