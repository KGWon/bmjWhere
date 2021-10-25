package com.example.bmjwhere.service;

import com.example.bmjwhere.dto.ClubMemberDTO;
import com.example.bmjwhere.entity.ClubMember;
import com.example.bmjwhere.entity.ClubMemberRole;
import com.example.bmjwhere.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service // 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성
@Log4j2
@RequiredArgsConstructor
public class ClubMemberServiceImpl implements ClubMemberService{

    private final ClubMemberRepository clubMemberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public String register2(ClubMemberDTO clubMemberDTO) {

        Map<String, Object> entityMap = dtoToEntity(clubMemberDTO);
        ClubMember clubMember = (ClubMember) entityMap.get("clubMember");

        String encodedPassword = passwordEncoder.encode(clubMember.getPassword());
        clubMember.setPassword(encodedPassword);
        clubMember.addMemberRole(ClubMemberRole.USER);

        clubMemberRepository.save(clubMember);

     return clubMember.getEmail();
    }}