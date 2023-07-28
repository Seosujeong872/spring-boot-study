package com.example.site1.domain.second.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.site1.domain.second.dto.PostDTO;
import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.model.post.entity.PostEntity;
import com.example.site1.model.post.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecondService {
    
    private final PostRepository postRepository;
    public ResSecondDTO getSecondData(){
        // // 안녕하세요 라는 title을 가진 List<PostEntity> 찾기
        //  postRepository.findByTitle("안녕하세요");

        //  // "안녕" title 이 포함된 List<PostEntity> 찾기
        //  postRepository.findByTitleContaining("안녕");

        //  // "첫번째" 라는 글자가 title 또는 content에 포함된 List<PostEntity> 찾기
        //  // select *
        //  // from post
        //  // where title like '%첫번째'
        //  // or content like '%첫번째'
        // postRepository.findByTitleContainingOrContentContaining("첫번째","첫번째");

        //  // "두번째" 라는 title과 "반갑습니다" 라는 content가 정확히 일치하는 List<PostEntity> 찾기
        // postRepository.findByTitleAndContent("두번째", "반갑습니다");

        // 모든 post 데이터 가져오기 List<PostEntity>
        List<PostEntity> postEntityList = postRepository.findAll();
       
        // List<PostEntity> 반복문 돌려서 PostDTO 만들기 (fooreach반복문)
        // List<PostDTO> 에 담기
        List<PostDTO> postDTOList = new ArrayList<>();
        for(PostEntity postEntity : postEntityList){
           PostDTO postDTO = new PostDTO(postEntity.getTitle(), postEntity.getContent(), postEntity.getIdx());
            postDTOList.add(postDTO);
        }

        // ResSecondDTO에 List<PostDTO> 담기
        ResSecondDTO resSecondDTO = new ResSecondDTO(postDTOList);
        // ResSecondDTO 리턴하기
        return resSecondDTO;

    }
}
