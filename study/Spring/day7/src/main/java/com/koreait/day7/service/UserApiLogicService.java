package com.koreait.day7.service;

import com.koreait.day7.model.entity.Users;
import com.koreait.day7.model.enumclass.UserStatus;
import com.koreait.day7.model.network.Header;
import com.koreait.day7.model.network.request.UserApiRequest;
import com.koreait.day7.model.network.response.UserApiResponse;
import com.koreait.day7.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, Users> {

    private final UsersRepository usersRepository;


    private UserApiResponse response(Users users){
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(users.getId())
                .userid(users.getUserid())
                .userpw(users.getUserpw())
                .name(users.getName())
                .hp(users.getHp())
                .email(users.getEmail())
                .regDate(users.getRegDate())
                .status(users.getStatus())
                .build();
        return userApiResponse;
    }



    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        Users users = Users.builder().userid(userApiRequest.getUserid())
                .userpw(userApiRequest.getUserpw())
                .name(userApiRequest.getName())
                .hp(userApiRequest.getHp())
                .email(userApiRequest.getEmail())
                .status(UserStatus.REGISTERED)
                .build();
        Users newUsers = baseRepository.save(users);
        return Header.Ok(response(newUsers));
    }



    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public Header<UserApiResponse> read(Long id) {
        return baseRepository.findById(id).map(users -> response(users)).map(Header::Ok)    //null이 아니라면
                .orElseGet(()->Header.ERROR("데이터 없음"));                        //null이라면
    }
    //-----------------------------------------------------------------------------------------------------------------


    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        Optional<Users> users = usersRepository.findByUserid(userApiRequest.getUserid());
        return users.map(
                user -> {
                    user.setUserpw(userApiRequest.getUserpw());
                    user.setName(userApiRequest.getName());
                    user.setHp(userApiRequest.getHp());
                    user.setEmail(userApiRequest.getEmail());
                    return user;
                }).map(user -> usersRepository.save(user))
                .map(user -> response(user))
                .map(Header::Ok)
                .orElseGet(()->Header.ERROR("데이터 없음")
        );
    }


    //-----------------------------------------------------------------------------------------------------------------
    @Override
    public Header delete(Long id) {
        Optional<Users> users =  baseRepository.findById(id);
        return users.map(
                user -> {
                    baseRepository.delete(user);
                    return Header.Ok();
                }).orElseGet(()->Header.ERROR("데이터 없음"));                        //null이라면
    }
}