package com.example.bmjwhere.service;

import com.example.bmjwhere.dto.ReviewDTO;
import com.example.bmjwhere.entity.ClubMember;
import com.example.bmjwhere.entity.Member;
import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.entity.Review;

import java.util.List;

public interface ReviewService {
    //    맛집의 모든 리뷰를 가져온다.
    List<ReviewDTO> getListOfResturant(Long rno);

    //    맛집 리뷰를 추가
    Long register(ReviewDTO resturantReviewDTO);

    //    특정한 맛집 리뷰 수정
    void modify(ReviewDTO resturantReviewDTO);

    //    맛집 리뷰 삭제
    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO resturantReviewDTO) {
        Review resturantReview = Review.builder()
                .reviewnum(resturantReviewDTO.getReviewnum())
                .resturant(Resturant.builder().rno(resturantReviewDTO.getRno()).build())
                .clubMember(ClubMember.builder().email(resturantReviewDTO.getEmail()).build())
                .grade(resturantReviewDTO.getGrade())
                .text(resturantReviewDTO.getText())
                .build();
        return resturantReview;
    }

    default ReviewDTO entityToDto(Review resturantReview) {
        ReviewDTO resturantReviewDTO = ReviewDTO.builder()
                .reviewnum(resturantReview.getReviewnum())
                .rno(resturantReview.getResturant().getRno())
                .email(resturantReview.getClubMember().getEmail())
                .name(resturantReview.getClubMember().getName())
                .grade(resturantReview.getGrade())
                .text(resturantReview.getText())
                .regDate(resturantReview.getRegDate())
                .modDate(resturantReview.getModDate())
                .build();

        return resturantReviewDTO;
    }
}
