package com.example.movies.domain.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.movies.domain.admin.service.AdminService;
import com.example.movies.domain.movie.dto.ResMoviePageDTO;

@Controller
public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();
        ResMoviePageDTO dto = adminService.getMovieList();
        modelAndView.addObject("dto",dto);
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @GetMapping("/admin/Update")
    public ModelAndView adminUpdate(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/adminUpdate");
        return modelAndView;
    }
}
