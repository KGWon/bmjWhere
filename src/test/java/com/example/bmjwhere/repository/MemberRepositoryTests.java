package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.ClubMember;
import com.example.bmjwhere.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private ClubMemberRepository clubMemberRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void test1() {
        System.out.println("testbbbbbbbbbbbbbbbbbbbbbbb");
    }

   /* @Test
    public void insertMember() {
        Member member = Member.builder()
                .email("test1@naver.com")
                .pw("1111")
                .nickname("TEST")
                .build();

        memberRepository.save(member);
    }

    @Test
    public void insertMembers(){
        IntStream.rangeClosed(1,100).forEach(i->{
            ClubMember clubMemberRepository = ClubMember.builder()
                    .email("r"+i+"naver.com")
                    .pw("1111")
                    .name("reviewer"+i).build();
            clubMemberRepository.save(clubMember);
        });
    }
    @Transactional
    @Commit
    @Test
    public void testDeleteMember(){
        String email = 'a@a.com';

        ClubMember clubMember = ClubMember.builder().email(email).build();

        reviewRepository.deleteByMember(clubMember);
        clubMemberRepository.deleteById(email);
    }*/
}