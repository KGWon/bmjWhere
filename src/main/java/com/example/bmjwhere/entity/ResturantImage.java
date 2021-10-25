package com.example.bmjwhere.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "resturant") //연관 관계 주의, @ToString은 항상 exclude, exclude:해당 속성값으로 지정된 변수는 toString()에서 제외된다, 지연로딩 사용시 반드시 선언
public class ResturantImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;  // 이미지 번호

    private String uuid; // 고유 식별 번호

    private String imgName; //이미지 이름

    private String path;  //저장 경로, 연월일 폴더 구조 의미

    //데이터베이스 상에서 외래키(FK) 의 관계로 연결된 엔티티 클래스에 설정, FETCH는 LAZY로딩, 혹은 EGAR로딩
    @ManyToOne(fetch = FetchType.LAZY)
    private Resturant resturant;
}