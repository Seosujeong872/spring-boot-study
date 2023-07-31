package com.example.site2.model.user.repository;

import java.sql.PreparedStatement;
import java.util.Optional;

import org.mariadb.jdbc.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.site2.model.user.entity.UserEntity;
import java.util.List;



public interface UserRepository extends JpaRepository<UserEntity,Long>{ // < 엔티티명, 프라이머리키 타입 >
    
    // select * from user where idx = ? 
    Optional<UserEntity>  findByIdx(Long idx); // 함수명만 만들어 주면 쿼리를 만들어준다.

    // select * from user where id = ?
    Optional<UserEntity> findById(String id);  // Optional : null체크를 하기위해

    // select * from user where password = ?
    List<UserEntity> findByPassword(String password); 

    // select *
    // from user
    // where idx = ?
    // and id = ?
    Optional<UserEntity> findByIdxAndId(Long idx, String id);


    // select *
    // from user
    // where id like '%?%';
     List<UserEntity> findByIdContaining(String id); // 여러개 들고 올 수 있어서 List

}

// class UserRepo{
//     Optional<UserEntity>  findByIdx(Long idx){
//         Connection connection = null;
//         PreparedStatement preparedStatement = null;
//         ResultSEt resultSet = null;

//         new UserEntity();

//         return null;
//     }
// }
