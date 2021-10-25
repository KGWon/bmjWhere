package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.Member;
import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

  /*  @Test
    public void insertResturantReview(){
        IntStream.rangeClosed(1,200).forEach(i->{
            Long rno = (long)(Math.random()*100)+1;

            Long mid = ((long)(Math.random()*100)+1);
            Member member = Member.builder().mid(mid).build();

            Review resturantReview = Review.builder()
                    .member(member)
                    .resturant(Resturant.builder().rno(rno).build())
                    .grade((int)(Math.random()*5)+1)
                    .text("이 식당에 대한 느낌...."+i)
                    .build();
            reviewRepository.save(resturantReview);
        });
    }
    @Test
    public void testGetResturantReviews(){
        Resturant resturant = Resturant.builder().rno(10L).build();
        List<Review> result = reviewRepository.findByResturant(resturant);

        result.forEach(resturantReview -> {
            System.out.println(resturantReview.getReviewnum());
            System.out.println("\t"+resturantReview.getGrade());
            System.out.println("\t"+resturantReview.getText());
            System.out.println("\t"+resturantReview.getMember().getEmail());
            System.out.println("----------------------------------");
        });
    }*/
}
