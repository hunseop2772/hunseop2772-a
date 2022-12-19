package com.koreait.day8.model.network.response;

import com.koreait.day8.model.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserApiResponse {
    private Long id;
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String email;
    private LocalDateTime regDate;
    private UserStatus status;
}
