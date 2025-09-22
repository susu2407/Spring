package kr.co.demo.ch06.repository.board;

import kr.co.demo.ch06.entity.board.AUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AUserRepository extends JpaRepository<AUser, String> {
}
