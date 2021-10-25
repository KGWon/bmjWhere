package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

}
