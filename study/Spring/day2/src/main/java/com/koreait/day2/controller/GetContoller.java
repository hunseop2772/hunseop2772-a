package com.koreait.day2.controller;

import com.koreait.day2.model.Member;
import org.springframework.web.bind.annotation.*;

@RestController// url을 호출할 수 있도록 해주는 기능
@RequestMapping("/api") // http://localgost:8888/api, 어노테이션
public class GetContoller {


    // http://localhost:8888/api/getmethod

    @RequestMapping(method= RequestMethod.GET, path = "/getmethod" ) // ==  @GetMapping("/getparameter2")
    // get으로 호출해야 들어온다
    public String getMethod(){
        return "getMethod() 호출!";
    }

    // http://localhost:8888/api/getparameter2?userid=apple&userpw=1234

    @RequestMapping(method = RequestMethod.GET, path ="getparameter1")
    public String getParameter1(@RequestParam String userid, @RequestParam String userpw){
        System.out.println("userid : " + userid );
        System.out.println("userpw : " + userpw );
        return "getParameter1() 호출!";
    }

    // http://localhost:8888/api/getparameter1?userid=apple&userpw=1234
    @GetMapping("/getparameter2")
    public String getParameter2(@RequestParam String userid, @RequestParam(name="userpw") String password){
        System.out.println("userid : " + userid );
        System.out.println("userpw : " + password );
        return "getParameter2() 호출!";
    }
    // http://localhost:8888/api/getmultiparameter1?userid=apple&userpw=1234&name=김사과&gender=여자&email=apple@asplle.com&age=20
    @GetMapping("getmultiparameter1")
    public String getMultiparameter1(
           @RequestParam String userid,
            @RequestParam String userpw,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String email,
            @RequestParam String age
    ){
        System.out.println("userid : " + userid );
        System.out.println("userpw : " + userpw );
        System.out.println("name : " + name );
        System.out.println("gender : " + gender );
        System.out.println("email : " + email );
        System.out.println("age : " + age );
        return "getmultiparameter1() 호출!";
    }

    // http://localhost:8888/api/getmultiparameter2?userid=apple&userpw=1234&name=김사과&gender=여자&email=apple@asplle.com&age=20
    @GetMapping("/getmultiparameter2")
    public Member getMultiParameter2(Member member){
        System.out.println(member);
        return member;
    }




}











