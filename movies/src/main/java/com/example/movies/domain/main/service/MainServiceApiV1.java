package com.example.movies.domain.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MainServiceApiV1 {

    private static final String API_KEY = "977c21eab7b6f2b3fcc5b70c02191d91";
    private static final String BASE_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";

     @Autowired
    private RestTemplate restTemplate;

     @Autowired
    private ObjectMapper objectMapper; // ObjectMapper를 주입받습니다.

    public String getMovieRanking(String targetDate) {
        String apiUrl = BASE_URL + "?key=" + API_KEY + "&targetDt=" + targetDate;

        String response = restTemplate.getForObject(apiUrl, String.class);
        
        return response;
        
    }

    
}
