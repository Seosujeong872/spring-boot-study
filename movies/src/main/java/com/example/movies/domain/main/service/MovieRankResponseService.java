package com.example.movies.domain.main.service;

import org.springframework.stereotype.Service;

@Service
public class MovieRankResponseService {

    // @Autowired
    // private KobisReposiory mainServiceApiV1; // MainServiceApiV1 주입받아서 사용준비.(박스오피스 api와 통신하여 데이터 가져옴)

    // @Autowired
    // private ObjectMapper objectMapper; //objectMapper : JSON 데이터를 DTO로 변환

    // // 박스오피스 api응답 데이터 가져와서 dto로 변환하여 반환.
    // public KobisBoxOffice getMovieRankResponseDTO(String targetDate) { // targetDate: 박스오피스 순위 가져올 날짜 파라미터. 
        
    //     // mainServiceApiV1을 통해 getMovieRanking 메서드를 호출하여 박스오피스 API 응답 데이터를 가져옴. (JSON 형식)
    //     String apiResponse = mainServiceApiV1.getMovieRanking(targetDate);

    //     // objectMapper.readValue는 Jackson 라이브러리에서 제공하는 메서드,
    //     // JSON 데이터를 Java 객체로 변환하는 기능을 수행
    //     try {
    //         // apiResponse 를 MovieRankResponseDTO 클래스의 객체로 변환 
    //         KobisBoxOffice movieRankResponseDTO = objectMapper.readValue(apiResponse, KobisBoxOffice.class);
    //         return movieRankResponseDTO;
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
}