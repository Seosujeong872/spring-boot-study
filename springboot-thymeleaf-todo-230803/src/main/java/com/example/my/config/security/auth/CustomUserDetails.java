package com.example.my.config.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.GraalImageCode;

@NoArgsConstructor
@AllArgsConstructor
@Getter


public class CustomUserDetails implements UserDetails {

    private User user;

    @AllArgsConstructor
    @Builder
    @Getter
    public static class User {
        private Long idx;
        private String id;
        private String password;
        private List<String> roleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for (String role : user.roleList) {
            GrantedAuthority grantedAuthority = new GrantedAuthority() {
                // 익명클래스
                @Override
                public String getAuthority(){
                    return "ROLE_" + role;
                }
                
            };
            grantedAuthority.add(grantedAuthority);
            
        }
        return grantedAuthorityList;

    }

    @Override
    public String getPassword() {
       return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
