package com.example.my.common.dto;

import com.example.my.model.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
            return User.builder()
                    .idx(userEntity.getIdx())
                    .id(userEntity.getId())
                    .password(userEntity.getPassword())
                    .roleList(
                            userEntity.getUserRoleEntityList()
                                    .stream()
                                    .map(userRoleEntity -> userRoleEntity.getRole())
                                    .toList()
                    )
                    .build();
        }
    }
}
