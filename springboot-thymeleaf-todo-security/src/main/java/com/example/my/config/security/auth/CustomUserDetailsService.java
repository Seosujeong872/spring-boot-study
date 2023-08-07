package com.example.my.config.security.auth;

import com.example.my.common.dto.LoginUserDTO;
import com.example.my.model.user.entity.UserEntity;
import com.example.my.model.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userEntityOptional = userRepository.findByIdAndDeleteDateIsNull(username);
        if (userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException("아이디를 정확히 입력해주세요.");
        }

        return new CustomUserDetails(LoginUserDTO.of(userEntityOptional.get()));

    }
}
