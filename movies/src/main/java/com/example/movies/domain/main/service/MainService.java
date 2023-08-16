package com.example.movies.domain.main.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movies.apimodel.kobis.entity.KobisBoxOffice;
import com.example.movies.apimodel.kobis.repository.KobisReposiory;
import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
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

        // kobisBoxOffice 가 null이 아닌 경우
        if (kobisBoxOffice != null) {

            // 영화순위,제목,postpath 담기위한 리스트 생성
            List<MainPageDTO.MovieRank> movieRankAndTitleList = new ArrayList<>();

            // kobisBoxOffice 에서 가져온 일별 박스오피스 정보 리스트
            List<KobisBoxOffice.boxOfficeResult.DailyBoxOffice> dailyBoxOfficeList = kobisBoxOffice.getBoxOfficeResult()
                    .getDailyBoxOfficeList();

            // dailyBoxOfficeList 내의 각 DailyBoxOffice 순회
            for (KobisBoxOffice.boxOfficeResult.DailyBoxOffice dailyBoxOffice : dailyBoxOfficeList) {

                // 해당 일의 영화 이름 가져오기
                String movieName = dailyBoxOffice.getMovieName();

                // tmdbRepository 통해서 영화 정보(postpath) 가져오기
                TmdbMovie tmdbMovieInfo = tmdbRepository.getMovieInfo(dailyBoxOffice.getMovieName());

                // tmdbMovie.getResults().size() 가 0이면 가짜 이미지 링크 넣기
                // http://via.placeholder.com/640x480
                // tmdbMovie.getResults().get(0).getPosterPath()

                String posterPath;

                // 이미지 정보가 없으면 임시 이미지 링크 설정
                if (tmdbMovieInfo.getResults().size() == 0) {
                    posterPath = "http://via.placeholder.com/640x480";
                } else { // 그렇지 않은 경우
                    // posterpath 가져오기
                    posterPath = tmdbMovieInfo.getResults().get(0).getPosterPath();
                }

                // MainPageDTO.MovieRank 객체 생성
                // 순위, 영화이름, 포스터 경로 리스트에 추가.
                MainPageDTO.MovieRank movieRank = MainPageDTO.MovieRank.builder()
                        .rank(dailyBoxOffice.getRank())
                        .movieName(movieName)
                        .posterPath(posterPath)
                        .build();
                movieRankAndTitleList.add(movieRank);
            }
            // kobisBoxOffice 가 null이 아닌 경우 리턴값
            // MainPageDTO 객체 빌더패턴 이용해서 구성
            // movieRankAndTitleList 에 순위,이름, 포스터 경로담은 리스트 movieRankAndTitleList 설정
            // MainPageDTO 객체 생성해서 반환.
            return MainPageDTO.builder()
                    .movieRankAndTitleList(movieRankAndTitleList)
                    .build();
        }
        // kobisBoxOffice 가 null 인경우 
        return MainPageDTO.builder()
                .movieRankAndTitleList(Collections.emptyList()) // 빈 리스트로 설정
                .build();
    }
}

// // posterPath 가져오는 함수
// public MainPageDTO getMainPageDTOByMoiveName(String movieName) {

// TmdbMovie tmdbPosterPath = tmdbRepository.getMovieInfo(movieName);

// if (tmdbPosterPath != null) {
// List<MainPageDTO.MoviePoster> moviePosterPathList = new ArrayList<>();
// List<MovieInfo> postPathList = tmdbPosterPath.getResults().getResults();

// for (MovieInfo posterPath : postPathList) {
// MainPageDTO.MoviePoster moviePoster = MainPageDTO.MoviePoster.builder()
// .posterPath(posterPath.getPosterPath())
// .build();
// moviePosterPathList.add(moviePoster);

// }
// return MainPageDTO.builder()
// .moviePosterPathList(moviePosterPathList)
// .build();

// }
// return MainPageDTO.builder()
// .moviePosterPathList(Collections.emptyList())
// .build();

// }

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

// 수정전
