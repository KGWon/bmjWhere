package com.example.bmjwhere.repository;

import com.example.bmjwhere.entity.Resturant;
import com.example.bmjwhere.entity.ResturantImage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class ResturantRepositoryTests {
    @Autowired
    private ResturantRepository resturantRepository;

    @Autowired
    private ResturantImageRepository imageRepository;

    @Commit
    @Transactional
    @Test
    public void insertResturants(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Resturant resturant = Resturant.builder().title("맛집...."+i).build();
            System.out.println("------------------------------------------------");
            resturantRepository.save(resturant);
            int count = (int)(Math.random()*5) +1; //1~5까지 랜덤생성
            for (int j = 0; j < count; j++){
                ResturantImage resturantImage = ResturantImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .resturant(resturant)
                        .imgName("test" + j + ".jpg").build();
                imageRepository.save(resturantImage);
                System.out.println("============================================");
            }
        });
    }
    @Test
    public void testListPage(){
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "rno"));
        Page<Object[]> result = resturantRepository.getListPage(pageRequest);

        for (Object[] objects : result.getContent()){
            System.out.println(Arrays.toString(objects));
        }
    }
    @Test
    public void testGetResturantWithAll(){
        List<Object[]> result = resturantRepository.getResturantWithAll(94L);
        System.out.println(result);
        for(Object[] arr : result){
            System.out.println(Arrays.toString(arr));
        }
    }
    @Test
    public void testSearch1() { // JPQL을 이용한 조회 테스트
        resturantRepository.search1();
    }
    @Test
    public void testSearchPage() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending().and(Sort.by("title").ascending()));

        Page<Object[]> result = resturantRepository.searchPage("t", "부산", pageable);
    }
}