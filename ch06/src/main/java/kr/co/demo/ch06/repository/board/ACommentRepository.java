package kr.co.demo.ch06.repository.board;

import kr.co.demo.ch06.entity.board.AComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ACommentRepository extends JpaRepository<AComment,Integer> {
}
