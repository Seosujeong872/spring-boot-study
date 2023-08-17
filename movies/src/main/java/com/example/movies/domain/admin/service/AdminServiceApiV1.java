package com.example.movies.domain.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movies.apimodel.tmdb.entity.TmdbMovie;
import com.example.movies.apimodel.tmdb.repository.TmdbRepository;
import com.example.movies.model.genre.entity.GenreEntity;
import com.example.movies.model.genre.repository.GenreRepository;
import com.example.movies.model.movie.entity.MovieEntity;
import com.example.movies.model.movie.entity.MovieGenreEntity;
import com.example.movies.model.movie.repository.MovieGenreRepository;
import com.example.movies.model.movie.repository.MovieRepository;

@Service
@Transactional(readOnly = true) // 읽기전용
public class AdminServiceApiV1 {

    @Autowired
    private TmdbRepository tmdbRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieGenreRepository movieGenreRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional // insert하기위해 붙임.
    public ResponseEntity<?> insertMovie() {

        // movieGenreRepository 관련된 모든 영화 장르 엔티티 삭제
        // movieRepository 관련된 모든 영화 엔티티 삭제
        // 삭제 안 하면 실행될때 마다 데이터가 들어가서 중복됨....
        movieGenreRepository.deleteAll();
        movieRepository.deleteAll();

        // 영화 목록 가져오기
        // tmdbRepository 에서 getPopularList 실행 -> List<TmdbMovie> tmdbMovieList 가져오기
        List<TmdbMovie> moviePopularList = tmdbRepository.getPopularList();

        // MovieEntity 만들어서 movieRepository 에서 save 실행. -> 결과값 받아오기

        for (TmdbMovie tmdbMovie : moviePopularList) {
            for (TmdbMovie.Result result : tmdbMovie.getResults()) {

                // MovieEntity 객체 생성
                MovieEntity movieEntityForSaving = MovieEntity.builder()
                        .movieName(result.getTitle())
                        .poster(result.getPosterPath())
                        .movieDate(result.getReleaseDate())
                        .country(result.getOriginalLanguage())
                        .summary(result.getOverview())
                        .build();

                // 생성한 movieEntityForSaving 저장
                MovieEntity movieEntity = movieRepository.save(movieEntityForSaving);

                // TmdbMovie 에서 genreIds + MovieEntity 결과값 이용해서 영화 장르 매핑....

                // 영화 결과의 장르 id 목록 순회
                for (Long genreId : result.getGenreIds()) {

                    // genreRepository 에서 해당 장르 id에 해당하는 GenreEntity 조회
                    Optional<GenreEntity> genreEntityOptional = genreRepository.findByIdx(genreId);

                    // Optional 객체에서 실제 GenreEntity 가져옴.
                    GenreEntity genreEntity = genreEntityOptional.get();

                    // 영화와 장르정보 기반으로 MovieGenreEntity 객체 생성
                    MovieGenreEntity movieGenreEntityForSaving = MovieGenreEntity.builder()
                            .movieEntity(movieEntity)
                            .genreEntity(genreEntity)
                            .build();

                    // 생성한 movieGenreEntityForSaving 저장
                    movieGenreRepository.save(movieGenreEntityForSaving);

                }
                // 영화 장르 엔티티 만들기.
                // 영화 장르 리파지토리에서 save 실행..

            }
        }

        // ResponseEntity 영화 save 성공...
        return new ResponseEntity<>(
                "영화정보 db 저장 성공",
                HttpStatus.OK);

    }

    // public void temp(Long movieIdx) {

    //     List<MovieEntity> movieEntityList = movieRepository.findAll();

    // }

}
