package com.example.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {
    
    @GetMapping("/coffee")
    public ModelAndView index(){
        System.out.println(this);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("coffee", "아메리카노");
        modelAndView.setViewName("coffee");
        return modelAndView;
    }
}
