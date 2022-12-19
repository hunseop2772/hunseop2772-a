package com.koreait.day8.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 일반 컨트롤러 생성 경우
@RequestMapping("") // http://localhost:8888
public class PageController {

    @RequestMapping(path="")
    public ModelAndView index(){
        return new ModelAndView("/index");// 페이지 이름과 동일해야한다.
    }

    @RequestMapping(path = "login") // http://localhost:8888/login
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    @RequestMapping(path = "register") // http://localhost:8888/register
    public ModelAndView register(){
        return new ModelAndView("/register");
    }
}
