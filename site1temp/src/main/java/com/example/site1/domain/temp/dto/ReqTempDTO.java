package com.example.site1.domain.temp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter // 꼭 넣어야 Request에 데이터가 들어간다.
public class ReqTempDTO {
    private String name;
    private Integer age;
}
