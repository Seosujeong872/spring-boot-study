package com.example.hr1.domain.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr1.common.dto.ResponseDTO;
import com.example.hr1.domain.main.dto.ReqInsertMainDTO;
import com.example.hr1.domain.main.dto.ReqUpdateMainDTO;
import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.service.MainService;

@RestController
@RequestMapping("/api/v1/main")
public class MainControllerApiV1 {

    @Autowired
    private MainService mainService;

    @GetMapping
    // @RequestMapping(method = RequestMethod.GET, value = "/api/v1/main")
    public List<ResMainDTO> getMainData(){
        return mainService.getMainPageData();
    }

    @PostMapping
    public ResponseDTO<Object> postMainData(@RequestBody ReqInsertMainDTO reqInsertMainDTO){
        // System.out.println(reqInsertMainDTO);
        mainService.postMainData(reqInsertMainDTO);

        return ResponseDTO.builder()
                .code(0)
                .message("region 등록에 성공했습니다.")
                .build();
    }

    @DeleteMapping("/{regionId}")
    public ResponseDTO<Object> deleteMainData(@PathVariable Integer regionId){
        // System.out.println("regionId : " + regionId);
        mainService.deleteMainData(regionId);

          return ResponseDTO.builder()
                .code(0)
                .message("region 삭제에 성공했습니다.")
                .build();
    }

    @PutMapping("/{regionId}")
    public ResponseDTO<Object> updateMainData(
        @PathVariable Integer regionId,
        @RequestBody ReqUpdateMainDTO reqUpdateMainDTO
        ){
            mainService.updateMainData(regionId, reqUpdateMainDTO);
             return ResponseDTO.builder()
                .code(0)
                .message("region 수정에 성공했습니다.")
                .build(); 

    }
    
}
