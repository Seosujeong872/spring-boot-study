package com.example.movies.domain.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.movies.domain.movie.dto.ResMoviePageDTO;
import com.example.movies.domain.movie.service.MovieService;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;
    
    @GetMapping("/main/movie")
    public ModelAndView Movie(){
        ModelAndView modelAndView = new ModelAndView();

        // movieService 사용하여 영화 정보 가져옴.
        ResMoviePageDTO moviePageDTO = movieService.getResMoviePageDTO();

        // 가져온 영화 정보를 dto 라는 이름으로 뷰에 전달.
        modelAndView.addObject("dto", moviePageDTO);


        modelAndView.setViewName("movie/moviePage");
        return modelAndView;
    }
    
    @GetMapping("/main/recommend")
    public ModelAndView Recommend(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("movie/recommend");
        return modelAndView;
    }

    @GetMapping("/main/movie-details/{movieIdx}")
    public ModelAndView MovieDetails(@PathVariable Long movieIdx){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movie/movieDetailsPage");
        return modelAndView;

    }

 
    
}
