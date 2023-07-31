package com.example.site2.domain.main.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResMainDTO {
    private List<MainUserDTO> mainUserDTOList;
}
