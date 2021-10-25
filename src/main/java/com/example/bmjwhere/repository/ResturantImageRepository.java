package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.ResturantImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResturantImageRepository extends JpaRepository<ResturantImage, Long> {
    @Modifying
    @Query("delete from ResturantImage ri where ri.resturant.rno = :rno") // 등록된 영화 삭제 전 영화 이미지들 삭제
    void deleteByImages(@Param("rno") Long rno);
}