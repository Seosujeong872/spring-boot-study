package com.example.site1.domain.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.site1.domain.second.dto.ResSecondDTO;
import com.example.site1.model.post.entity.PostEntity;
import com.example.site1.model.post.repository.PostRepository;

@Service
public class SecondService {
    @Autowired
    private PostRepository postRepository;

    public List<ResSecondDTO> getSecondData(){
        

        return postRepository.findAll()
            .stream()
            .map((postEntity)->ResSecondDTO.fromEntity(postEntity))
            .toList();

        
    }
}
