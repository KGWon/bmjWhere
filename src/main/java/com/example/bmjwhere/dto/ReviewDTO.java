package com.example.bmjwhere.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long reviewnum;  //리뷰번호
    private Long rno;   //맛집 번호
//    private Long mid;   //회원ID
private String email;
    private String name;
  //  private String nickname; //회원별칭
   // private String email; //회원 이메일
    private int grade; //평점
    private String text; //리뷰 내용
    private LocalDateTime regDate, modDate; //리뷰 등록, 수정시간
}