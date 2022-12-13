package com.koreait.day6.model.config;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getRegDate();
    LocalDateTime getUpdateDate();

    void setRegDate(LocalDateTime regDate);// 인터페이스 역할 수행
    void setUpdateDate(LocalDateTime updateDate);
}
