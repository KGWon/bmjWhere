package com.example.bmjwhere.service;

import com.example.bmjwhere.dto.ReviewDTO;
import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.entity.Review;
import com.example.bmjwhere.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> getListOfResturant(Long rno) {
        Resturant resturant = Resturant.builder().rno(rno).build();
        List<Review> result = reviewRepository.findByResturant(resturant);
        return result.stream().map(resturantReview -> entityToDto(resturantReview))
                .collect(Collectors.toList());
    }

    @Override
    public Long register(ReviewDTO resturantReviewDTO) {
        Review resturantReiew = dtoToEntity(resturantReviewDTO);
        reviewRepository.save(resturantReiew);
        return resturantReiew.getReviewnum();
    }

    @Override
    public void modify(ReviewDTO resturantReviewDTO) {
        Optional<Review> result = reviewRepository.findById(resturantReviewDTO.getReviewnum());
        if(result.isPresent()){
            Review resturantReview = result.get();
            resturantReview.changeGrade(resturantReviewDTO.getGrade());
            resturantReview.changeText(resturantReviewDTO.getText());
            reviewRepository.save(resturantReview);
        }
    }

    @Override
    public void remove(Long reviewnum) {
        reviewRepository.deleteById(reviewnum);
    }




    }
