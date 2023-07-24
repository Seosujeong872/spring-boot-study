package com.example.hr1.domain.main.dto;

import com.example.hr1.model.regions.entity.RegionsEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResMainDTO {

    private Integer regionsId;
    private String regionsName;
    
    public static ResMainDTO fromEntity(RegionsEntity regionsEntity){
        return new ResMainDTO(regionsEntity.getRegionId(), regionsEntity.getRegionName());
    }

}
