package kr.co.demo.ch06.repository.board;

import jakarta.transaction.Transactional;
import kr.co.demo.ch06.entity.board.Article;
import kr.co.demo.ch06.entity.board.AComment;
import kr.co.demo.ch06.entity.board.AUser;
import kr.co.demo.ch06.entity.board.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ACommentRepository aCommentRepository;

    @Autowired
    private AUserRepository aUserRepository;

    @Autowired
    private FileRepository fileRepository;

    @Test
    void insertAUserTest() {

        AUser aUser = AUser.builder()
                .userid("a204")
                .name("양송이")
                .age(30)
                .build();

        aUserRepository.save(aUser);

    }

    @Test
    void insertArticleTest() {

        AUser auser = AUser.builder()
                .userid("a110")
                .build();

        Article article = Article.builder()
                .title("옛날옛날어느날")
                .content("한 인어가 한 왕자를 살림")
                .aUser(auser)
                .build();

        articleRepository.save(article);
    }

    @Test
    void insertFileTest(){

        Article article = Article.builder()
                .ano(1)
                .build();

        File file = File.builder()
                .oName("매출자료2.xls")
                .sName("akfal-asd-1213dsdf.xls")
                .build();

        fileRepository.save(file);
    }


    @Test
    void insertCommentTest() {

        Article article = Article.builder()
                .ano(1)
                .build();

        AComment aComment = AComment.builder()
                .content("댓글")
                .author("a110")
                .article(article)
                .build();

        aCommentRepository.save(aComment);
    }

    @Test
    @Transactional
    void selectArticleAllTest() {

        List<Article> articleList = articleRepository.findAll();
        //System.out.println(articleList);

        for(Article article : articleList) {

            //System.out.println(article);

            for(AComment comment : article.getACommentList()) {
                System.out.println(comment);
            }
        }
    }

    @Test
    @Transactional // Transaction 처리, 엔티티 연관관계에서 한번 이상의 SQL 처리가 이루어 지기 때문에 단일 작업 처리를 위해 트랜젝션 처리, 안하면 no session 에러
    void selectArticle() {

        Optional<Article> optArticle = articleRepository.findById(1);
        //System.out.println(optArticle);

        if (optArticle.isPresent()) {

            Article article = optArticle.get();
            List<AComment> ACommentList = article.getACommentList();

            for (AComment comment : ACommentList) {
                System.out.println(comment);
            }

            List<File> fileList = article.getFileList();
            for (File file : fileList) {
                System.out.println(file);
            }

        }
    }

}
