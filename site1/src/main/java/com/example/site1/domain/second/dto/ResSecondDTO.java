package com.example.site1.domain.second.dto;

import com.example.site1.model.post.entity.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResSecondDTO {
    private String title;
    private String content;
    private Integer userIdx;

    public static ResSecondDTO fromEntity(PostEntity postEntity){
        // ResSecondDTO resSecondDTO = new ResSecondDTO();
        // resSecondDTO.setTitle(postEntity.getTitle());
        // resSecondDTO.setContent(postEntity.getContent());
        // resSecondDTO.setUserIdx(postEntity.getUserIdx());
        // return resSecondDTO;
        return ResSecondDTO.builder()
            .title(postEntity.getTitle())
            .content(postEntity.getContent())
            .userIdx(postEntity.getUserEntity().getIdx())
            .build();
    }
}
