package com.example.site2.model.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.site2.model.post.entity.PostEntity;
import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository<PostEntity, Long>{

    @Query(value = "select * from post where title = ?", nativeQuery = true)
    void getPostList(String title);


    // select * from post where idx = ?
    Optional<PostEntity> findByIdx(Long idx); // 글번호로 검색하기

    // select * from post where title = ?
    List<PostEntity> findByTitle(String title); // 제목으로 검색하기

    // select * from post where content = ?
    List<PostEntity> findByContent(String content); // 내용으로 검색하기

    // // select * from post where user_idx = ?
    // List<PostEntity>  findByUserIdx(Long userIdx);

    // select *
    // from post 
    // where title = ?
    // or content = ?
    List<PostEntity> findByTitleOrContent(String title, String content);

    // select *
    // from post 
    // where title like '%?%'
    // or content like '%?%'; 
    List<PostEntity> findByTitleContainingOrContentContaining(String title, String content);
 }
