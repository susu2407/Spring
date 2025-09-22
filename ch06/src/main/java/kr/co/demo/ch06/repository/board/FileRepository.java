package kr.co.demo.ch06.repository.board;

import kr.co.demo.ch06.entity.board.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Integer> {
}
