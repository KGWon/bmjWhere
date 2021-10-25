package com.example.bmjwhere.controller;

import com.example.bmjwhere.dto.ReviewDTO;
import com.example.bmjwhere.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{rno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("rno") Long rno){
        log.info("------------------list-----------------------");
        log.info("RNO: "+ rno);
        List<ReviewDTO> reviewDTOList = reviewService.getListOfResturant(rno);
        return new ResponseEntity<>(reviewDTOList, HttpStatus.OK);
    }
    @PostMapping("/{rno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO resturantReviewDTO){
        log.info("=---------------add ResturantReview--------------------------=");
        log.info("reviewDTO: "+ resturantReviewDTO);
        Long reviewnum = reviewService.register(resturantReviewDTO);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
    @PutMapping("/{rno}/{reviewnum}")
    public ResponseEntity<Long> modifyReview(@PathVariable Long reviewnum,
                                             @RequestBody ReviewDTO resturantReviewDTO){
        log.info("-----------------------modify ResturantReciew---------------"+reviewnum);
        log.info("reviewDTO: "+resturantReviewDTO);
        reviewService.modify(resturantReviewDTO);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
    @DeleteMapping("/{rno}/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewnum){
        log.info("-----------------modify removeReview-------------------");
        log.info("reviewnum:  "+reviewnum);
        reviewService.remove(reviewnum);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
}
