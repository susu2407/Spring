package kr.co.demo.ch06.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
// 엔티티 관계설정에서 엔티티의 toString()을 호출되면 또 다른 엔티티의 toString() 호출되기 때문에 엔티티간의 toString() 호출로 stackoverflow 에러 발생
// 엔티티의 어느 한쪽에서는 toString(0 호출을 제외(exclude)에서 순환 참조 호출 방지
@ToString(exclude = {"ACommentList", "fileList"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ano;        // 글번호
    private String title;   // 제목
    private String content; // 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private AUser aUser;      //private String author;  // 작성자(사용자 id)

    //@OneToMany 관계설정에 반드시 mappedBy 속성은 양방향 관계에서 기준이 되는 속성, FK가 되는 속성
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<AComment> ACommentList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ano") // OneToMany에서 JoinColumn으로 File 엔티티에 ano FK 생성
    private List<File> fileList;

    @CreationTimestamp
    private LocalDateTime wdate;   // 작성일 // JPA 현재 날짜시간 클래스로 @CreationTimestamp 어노테이션으로 현재 날짜 시간 처리
}
