package com.example.my.common.dto;

import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.entity.UserRoleEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class LoginUserDTO {

    private User user;

    public static LoginUserDTO of(UserEntity userEntity) {
        return LoginUserDTO.builder()
                .user(User.fromEntity(userEntity))
                .build();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @ToString
    public static class User {
        private Long idx;
        private String id;
        private String password;
        private List<String> roleList;

        public static User fromEntity(UserEntity userEntity) {


            // map 사용하는 방법
            return User.builder()
                    .idx(userEntity.getIdx())
                    .id(userEntity.getId())
                    .password(userEntity.getPassword())
                    .roleList( userEntity.getUserRoleEntityList()
                                .stream() // 컨베이어벨트
                                .map(userRoleEntity -> userRoleEntity.getRole()) //  원래의 타입을 다른 타입으로 바꾸고 싶을 때
                                .toList() // 리스트로 모아준다.
                    )
                    .build();

            // map 사용 안하는 방법
            // List<UserRoleEntity> userRoleEntityList = userEntity.getUserRoleEntityList();
            // List<String> roleList = new ArrayList<>();
            // for (UserRoleEntity userRoleEntity : userRoleEntityList) {
            //     roleList.add(userRoleEntity.getRole());
            // }


            // return User.builder()
            //         .idx(userEntity.getIdx())
            //         .id(userEntity.getId())
            //         .password(userEntity.getPassword())
            //         .roleList(roleList)
            //         .build();
        }
    }
}


