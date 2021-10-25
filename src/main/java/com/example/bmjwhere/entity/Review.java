package com.example.bmjwhere.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"resturant", "clubMember"})
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Resturant resturant;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClubMember clubMember;

    private int grade;

    private String text;

    public void changeGrade(int grade){
        this.grade = grade;
    }
    public void changeText(String text){
        this.text=text;
    }

}