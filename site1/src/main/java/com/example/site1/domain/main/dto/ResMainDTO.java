package com.example.site1.domain.main.dto;

import com.example.site1.model.user.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ResMainDTO {
    private Integer idx;
    private String id;

    public static ResMainDTO fromEntity(UserEntity userEntity){
        // return new ResMainDTO(siteEntity.getIdx(), siteEntity.getId());
        return ResMainDTO.builder()
            .id(userEntity.getId())
            .build();
    }
}
