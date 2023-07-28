package com.example.site1.domain.second.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDTO {
    private String title;
    private String content;
    private Integer userIdx;
}
