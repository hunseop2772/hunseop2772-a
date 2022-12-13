package com.koreait.day6.ifs;

import com.koreait.day6.model.network.Header;

public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request);
    // create(Header<Req>요청하면 반환은Header<Res>
    Header<Res> read(Long id);
    Header<Res> update(Header<Req> request);
    Header<Res> delete(Long id);
}
