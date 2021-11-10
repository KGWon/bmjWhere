package com.example.bmjwhere.service;

import com.example.bmjwhere.dto.ClubMemberDTO;
import com.example.bmjwhere.entity.ClubMember;
import com.example.bmjwhere.entity.ClubMemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public interface ClubMemberService  {


    String register2(ClubMemberDTO clubMemberDTO);  
    default Map<String, Object> dtoToEntity(ClubMemberDTO clubMemberDTO) {  
        Map<String, Object> entityMap = new HashMap<>();
 
        ClubMember clubMember = ClubMember.builder()
                .email(clubMemberDTO.getEmail())
                .name(clubMemberDTO.getName())
                .fromSocial(false)
                .password(clubMemberDTO.getPassword())
                .build();


        clubMember.addMemberRole(ClubMemberRole.USER);

        entityMap.put("clubMember", clubMember);  
        return entityMap;
    }

    default ClubMemberDTO entitiesToDTO(ClubMember clubMember) {
      
        ClubMemberDTO clubMemberDTO = ClubMemberDTO.builder()
                .email(clubMember.getEmail())
                .name(clubMember.getName())
                .password(clubMember.getPassword())
                .build();


        return clubMemberDTO;
    }
    }
