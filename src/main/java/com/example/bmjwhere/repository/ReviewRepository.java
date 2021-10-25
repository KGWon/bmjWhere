package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.ClubMember;
import com.example.bmjwhere.entity.Member;
import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @EntityGraph(attributePaths = {"clubMember"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByResturant(Resturant resturant);

    @Modifying
    @Query("delete from Review mr where mr.clubMember = :clubMember")
    void deleteByMember(ClubMember clubMember);

    @Modifying
    @Query("delete from Review mr where mr.resturant.rno = :rno") // 등록된 영화 삭제 전 리뷰 삭제
    void deleteByReviews(@Param("rno") Long rno);
}
