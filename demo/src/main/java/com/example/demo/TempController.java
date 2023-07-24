package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
// @Component - IoC에 등록될 객체라고 알림
@Controller
public class TempController {

    // @~Mapping 화면 주소를 설정하는 어노테이션
     @GetMapping("/hello")
    public ModelAndView index(){
        // this는 클래스로 만든 인스턴스 - 자기 자신
        System.out.println(this);
        // 출력할 화면과 데이터를 세팅하는 객체
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",Math.random());
        modelAndView.setViewName("first");
        return modelAndView;
    }
     @GetMapping("/lucky")
    public ModelAndView index2(){
        // this는 클래스로 만든 인스턴스 - 자기 자신
        System.out.println(this);
        // 출력할 화면과 데이터를 세팅하는 객체
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("number",((int)(Math.random()*10)+1));
        modelAndView.setViewName("second");
        return modelAndView;
    }
}
