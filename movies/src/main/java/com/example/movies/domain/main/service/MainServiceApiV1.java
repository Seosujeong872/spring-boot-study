package com.example.movies.domain.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.movies.apimodel.kobis.entity.KobisBoxOffice;
import com.example.movies.apimodel.kobis.entity.KobisBoxOffice.boxOfficeResult.DailyBoxOffice;
import com.example.movies.apimodel.kobis.repository.KobisReposiory;

@Service
public class MainServiceApiV1 {

    @Autowired
    private KobisReposiory kobisReposiory;

    public ResponseEntity<?> getMovieRankAndTitleList(String targetDate) {
        KobisBoxOffice kobisBoxOffice = kobisReposiory.getKobisBoxOfficeByTargetDate(targetDate);

        // 순위와 제목 저장할 리스트.
        List<String> movieRankAndTitleList = new ArrayList<>();

        if (kobisBoxOffice != null) {
            // DTO에서 박스오피스 순위 데이터를 가져와서 가공.

            List<DailyBoxOffice> dailyBoxOfficeList = kobisBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

            for (DailyBoxOffice dailyBoxOffice : dailyBoxOfficeList) {
                String movieRankAndTitle = "순위: " + dailyBoxOffice.getRank() + ", 제목: " + dailyBoxOffice.getMovieName();
                movieRankAndTitleList.add(movieRankAndTitle);
            }
        }

        return new ResponseEntity<>(
            movieRankAndTitleList,
            HttpStatus.OK
        );

    }

}
