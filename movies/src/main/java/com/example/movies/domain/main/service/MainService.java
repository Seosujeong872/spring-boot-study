package com.example.movies.domain.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.apimodel.kobis.entity.KobisBoxOffice;
import com.example.movies.apimodel.kobis.repository.KobisReposiory;
import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
import com.example.movies.apimodel.tmdb.entity.TmdbMovie.results;
import com.example.movies.apimodel.tmdb.entity.TmdbMovie.results.MovieInfo;
import com.example.movies.apimodel.tmdb.repository.TmdbRepository;
import com.example.movies.domain.main.dto.MainPageDTO;

@Service
public class MainService {

    // KobisReposiory 를 주입받아서 사용할 준비
    // kobisReposiory 를 통해 박스오피스 응답 데이터 dto로 가져옴.
    @Autowired
    private KobisReposiory kobisReposiory;

    @Autowired
    private TmdbRepository tmdbRepository;

    // targetDate : 해당날짜 파라미터
    // 박스오피스 데이터 가져와서 MainPageDTO 로 반환
    public MainPageDTO getMainPageDTOByTargetDate(String targetDate) {

        // KobisReposiory 로 해당날짜 의 박스오피스 응답데이터 가져오기.
        KobisBoxOffice kobisBoxOffice = kobisReposiory.getKobisBoxOfficeByTargetDate(targetDate);

        // System.out.println(kobisBoxOffice);

        // 순위와 제목 저장할 리스트 생성.
        // List<String> movieRankAndTitleList = new ArrayList<>();

        // // 박스오피스 데이터가 null 이 아닐 때
        // if (kobisBoxOffice != null) {

        // // kobisBoxOffice 에서 박스오피스 순위데이터 가져오기.
        // List<DailyBoxOffice> dailyBoxOfficeList =
        // kobisBoxOffice.getBoxOfficeResult().getDailyBoxOfficeList();

        // // 순위와 제목 가공.
        // for (DailyBoxOffice dailyBoxOffice : dailyBoxOfficeList) {
        // String movieRankAndTitle = "순위: " + dailyBoxOffice.getRank() + ", 제목: " +
        // dailyBoxOffice.getMovieName();
        // movieRankAndTitleList.add(movieRankAndTitle);
        // }
        // }

        // // 가공한 순위와 제목 정보를 가지고 MainPageDTO 객체 생성하고 반환.
        // return new MainPageDTO(movieRankAndTitleList);

        // 수정

        if (kobisBoxOffice != null) {
            List<MainPageDTO.MovieRank> movieRankAndTitleList = new ArrayList<>();
            List<KobisBoxOffice.boxOfficeResult.DailyBoxOffice> dailyBoxOfficeList = kobisBoxOffice.getBoxOfficeResult()
                    .getDailyBoxOfficeList();

            for (KobisBoxOffice.boxOfficeResult.DailyBoxOffice dailyBoxOffice : dailyBoxOfficeList) {
                MainPageDTO.MovieRank movieRank = MainPageDTO.MovieRank.builder()
                        .rank(dailyBoxOffice.getRank())
                        .movieName(dailyBoxOffice.getMovieName())
                        .build();
                movieRankAndTitleList.add(movieRank);
            }

            return MainPageDTO.builder()
                    .movieRankAndTitleList(movieRankAndTitleList)
                    .build();
        }
        return MainPageDTO.builder()
                .movieRankAndTitleList(Collections.emptyList())
                .build();
    }

    // posterPath 가져오는 함수
    public MainPageDTO getMainPageDTOByMoiveName(String movieName) {

        TmdbMovie tmdbPosterPath = tmdbRepository.getMovieInfo(movieName);

        if (tmdbPosterPath != null) {
            List<MainPageDTO.MoviePoster> moviePosterPathList = new ArrayList<>();
            List<MovieInfo> postPathList = tmdbPosterPath.getResults().getResults();

            for (MovieInfo posterPath : postPathList) {
                MainPageDTO.MoviePoster moviePoster = MainPageDTO.MoviePoster.builder()
                        .posterPath(posterPath.getPosterPath())
                        .build();
                moviePosterPathList.add(moviePoster);

            }
            return MainPageDTO.builder()
            .moviePosterPathList(moviePosterPathList)
            .build();

        }
        return MainPageDTO.builder()
        .moviePosterPathList(Collections.emptyList())
        .build();

        
    }
}