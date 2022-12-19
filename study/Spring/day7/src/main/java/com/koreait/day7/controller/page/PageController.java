package com.koreait.day7.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 일반 컨트롤러 생성 경우
@RequestMapping("pages") // http://localhost:8888/pages
public class PageController {

    @RequestMapping(path="/cafe") //http://localhost:8888/pages/cafe
    public ModelAndView cafe(){
        return new ModelAndView("/cafe_index.html");
    }
}
