package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.repository.search.SearchResturantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResturantRepository extends JpaRepository<Resturant, Long>, SearchResturantRepository {

    //e는 Resturant ri는 ResturantImage

    @Query("select e, ri, avg(coalesce(r.grade,0)), count(r) from Resturant e "
            + "left outer join ResturantImage ri on ri.resturant = e "
            + "left outer join Review r on r.resturant = e group by e")
    Page<Object[]> getListPage(Pageable pageable);  //페이징 처리

    //r은 Review
    @Query("select e, ri, avg(coalesce(r.grade,0)), count(r) from Resturant e " +
            "left outer join ResturantImage ri on ri.resturant = e " +
            "left outer join Review r on r.resturant = e " +
            "where e.rno = :rno group by ri")
    List<Object[]> getResturantWithAll(@Param("rno") Long rno); //@Param 안쓰면 에러남 ㅠㅠ

//    @Query("select e, ri, avg(coalesce(r.grade,0)), count(r) from Resturant e "
//            + "left outer join ResturantImage ri on ri.resturant = e "
//            + "left outer join Review r on r.resturant = e where e.type= e.type"일식" group by e")
//    Page<Object[]> getjListPage(Pageable pageable);  //페이징 처리


}
