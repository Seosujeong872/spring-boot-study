package com.example.movies.apimodel.kobis.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.movies.apimodel.kobis.entity.KobisBoxOffice;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class KobisReposiory {

    private static final String API_KEY = "977c21eab7b6f2b3fcc5b70c02191d91";
    private static final String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper; // objectMapper : JSON 데이터를 객체로 변환하기위해 사용.


    // targetDate 파라미터로 받아서 해당 날짜의 박스오피스 데이터 가져오는 함수
    public KobisBoxOffice getKobisBoxOfficeByTargetDate(String targetDate) {
       
       // Api요청 URL생성
        String apiUrl = BASE_URL + "?key=" + API_KEY + "&targetDt=" + targetDate;

        // 생성한 URL로 HTTP GET 요청을 보내고, 응답데이터를 문자열로 받음.
        String response = restTemplate.getForObject(apiUrl, String.class);

        // objectMapper.readValue는 Jackson 라이브러리에서 제공하는 메서드,
        // JSON 데이터를 Java 객체로 변환하는 기능을 수행
        try {
            // response 를 KobisBoxOffice 클래스의 객체로 변환
            KobisBoxOffice kobisBoxOffice = objectMapper.readValue(response, KobisBoxOffice.class);
            System.out.println("kobisBoxOffice :" + kobisBoxOffice);
            // 변환된 KobisBoxOffice 객체 반환.
            return kobisBoxOffice;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    

}
