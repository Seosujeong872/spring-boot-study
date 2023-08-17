package com.example.my.model.user.repository;

import com.example.my.model.user.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    List<UserRoleEntity> findByUserEntity_Idx(Long userIdx);

    UserRoleEntity findByUserEntity_IdxAndRole(Long userIdx, String role);

}
