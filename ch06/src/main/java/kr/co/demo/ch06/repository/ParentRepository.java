package kr.co.demo.ch06.repository;

import kr.co.demo.ch06.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, String> {
}
