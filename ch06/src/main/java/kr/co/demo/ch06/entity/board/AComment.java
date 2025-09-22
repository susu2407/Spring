package kr.co.demo.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AComment")
public class AComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;


    @ManyToOne(fetch = FetchType.LAZY)  // 관계설정
    @JoinColumn(name = "ano")           // FK 이름 설정 //Article의 ano가 외래키가 된다.
    private Article article;            // private String ano; // 객체지향 관점에서 생각해서.


    private String content; // 내용
    private String author;  // 작성자

    @CreationTimestamp
    private LocalDateTime wdate;   // 작성일 // JPA 현재 날짜시간 클래스로 @CreationTimestamp 어노테이션으로 현재 날짜 시간 처리

}
