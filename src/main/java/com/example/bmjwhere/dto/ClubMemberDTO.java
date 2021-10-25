package com.example.bmjwhere.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClubMemberDTO {
    //private Long Cno;
    private String email;
    private String password;
    private String name;
    private boolean fromSocial;

}
