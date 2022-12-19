package com.koreait.day7.controller.api;

import com.koreait.day7.controller.CrudController;
import com.koreait.day7.model.entity.Users;
import com.koreait.day7.model.network.Header;
import com.koreait.day7.model.network.request.UserApiRequest;
import com.koreait.day7.model.network.response.UserApiResponse;
import com.koreait.day7.repository.UsersRepository;
import com.koreait.day7.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")    // http://localhost:8888/api/user
@RequiredArgsConstructor
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse, Users> {
    private final UserApiLogicService userApiLogicService;
    private final UsersRepository usersRepository;

    /*
        {
            "transaction_time":"2022-12-14",
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "userid":"ryuzy",
                "userpw":"1111",
                "name":"류정원",
                "hp":"010-1111-1111",
                "email":"ryuzy@naver.com"
            }
        }
     */
    @Override
    @PostMapping("") // http://localhost:8888/api/user (post)
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")     //http://localhost:8888/api/user/{id}   (get)
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     //http://localhost:8888/api/user/ 포스트와 유사 (put)
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") //http://localhost:8888/api/user/{id} (delete)
    public Header<UserApiResponse> delete(@PathVariable Long id) {
        return userApiLogicService.delete(id);
    }
}