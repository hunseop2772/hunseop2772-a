package com.koreait.day8.controller;

import com.koreait.day8.ifs.CrudInterface;
import com.koreait.day8.model.network.Header;
import org.springframework.stereotype.Component;

@Component // Bean으로 사용하기 위해, 나중에 Controller을 상속하여 사용하기 위해
// 다른 기능들로 추가하기 위해 데이터를 주입받아 Header를 사용?
// 기본적으로 타입기반의 자동주입 어노테이션(Autowired 비슷한 기능)
public abstract class CrudController<Req, Res, Entity> implements CrudInterface<Req, Res> {
    @Override
    public Header<Res> create(Header<Req> request) {
        return null;
    }

    @Override
    public Header<Res> read(Long id) {
        return null;
    }

    @Override
    public Header<Res> update(Header<Req> request) {
        return null;
    }

    @Override
    public Header<Res> delete(Long id) {
        return null;
    }


}
