package com.koreait.day8.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserApiRequest {
    private String userid;
    private String userpw;
    private String name;
    private String hp;
    private String email;

}
