package com.example.bmjwhere.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReplyService {

    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // SecurityContextHolder에는 인증된 객체의 정보만 들어감
        Object principal = authentication.getPrincipal(); // 인증 사용자를 나타냄 (getPrincipal) 누구냐? (UserDetailsService에서 리턴한 User 객체)
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 인증사용자가 가지고 있는 권한을 나타냄 (getAuthorities)
        // (UserDetailsService에서 리턴한 User 객체)
        Object credentials = authentication.getCredentials(); // 크리덴셜
        boolean authenticated = authentication.isAuthenticated(); // 인증된 사용자냐? (로그인 상태라면 True)
        // 권한정보는 AccountService에 기재된 UserDetailsService를 기반으로 작성됨
        // ThreadLocal을 사용하는 SpringContextHolder는 최종적으로 Authentication 담고있으며 Application 어디에서든 사용 가능하도록 해줌
        // Authority에는 Princial, GrantAuthority 두개의 정보가 들어있음
    }


    }
