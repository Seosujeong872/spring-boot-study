package com.example.my.domain.todo.controller;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.domain.todo.dto.ResTodoTableDTO;
import com.example.my.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping({"", "/"})// 배열로 경로 여러개 넣었다.
    public ModelAndView todoTablePage(HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView();
         // 세션에서 유저정보가 null이면 로그인페이지로 강제이동
        if(session.getAttribute("dto")==null){
            modelAndView.setViewName("redirect:/auth/login");
            return modelAndView;
        }



        // null이 아니면 todo정보 담아서 메인 페이지 이동
        System.out.println(session.getAttribute("dto"));
       
        // // 세션아 loginUserDTO 좀 줘
        // LoginUserDTO loginUserDTO = (loginUserDTO)session.getAttribute("dto");
        // // 서비스야 투두 dto 좀 줘
        // ResTodoTableDTO dto = todoService.getTodoTableData(loginUserDTO);


       // 서비스에서 만든 dto를 모델에 담기 
        ResTodoTableDTO dto = todoService.getTodoTableData((LoginUserDTO) session.getAttribute("dto"));
        modelAndView.addObject("dto", dto);
       
        modelAndView.setViewName("todo/table");
        return modelAndView;
    }

}
