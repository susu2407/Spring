package kr.co.demo.ch06.repository;

import kr.co.demo.ch06.dto.User1DTO;
import kr.co.demo.ch06.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface User1Repository extends JpaRepository<User1, String> { // <엔티티, 해당 엔티티의 @Id t속성 자료형

    // 사용자 쿼리 메서드 정의
    public User1 findUser1ByUserid(String userid);
    public List<User1> findUser1ByName(String name); // 이 것의 쿼리 : select * from User1 where name=?
    public List<User1> findUser1ByNameNot(String name);

    public User1 findUser1ByUseridAndName(String userid, String name); // Service의 findById와 동일
    public List<User1> findUser1ByUseridOrName(String userid, String name);

    public List<User1> findUser1ByAgeGreaterThan(int age);
    public List<User1> findUser1ByAgeGreaterThanEqual(int age);
    public List<User1> findUser1ByAgeLessThan(int age);
    public List<User1> findUser1ByAgeLessThanEqual(int age);
    public List<User1> findUser1ByAgeBetween(int low, int high);

    public List<User1> findUser1ByNameLike(String name);
    public List<User1> findUser1ByNameContains(String name);
    public List<User1> findUser1ByNameStartsWith(String name);
    public List<User1> findUser1ByNameEndsWith(String name);

    public List<User1> findUser1ByOrderByName();
    public List<User1> findUser1ByOrderByAgeAsc();
    public List<User1> findUser1ByOrderByAgeDesc();
    public List<User1> findUser1ByAgeGreaterThanOrderByAgeDesc(int age);

    public int countUser1ByUserid(String userid);
    public int countUser1ByName(String name);


    // JOIN일 때에는 쿼리를 직접 작성해야 한다.
    // JPQL(JPA SQL) 실습
    @Query("SELECT u1 FROM User1 as u1 WHERE u1.age < 30") // * 대신에 AS명을 작성해야 한다.
    public List<User1> selectUser1UnderAge30();

    @Query("SELECT u1 FROM User1 as u1 WHERE u1.name =?1")
    public List<User1> selectUser1WhereName(String name);

    // 파라미터 변수
    @Query("SELECT u1 FROM User1 as u1 WHERE u1.birth = :birth")
    public List<User1> selectUser1WhereBirth(@Param("birth") String birth);

    // 프로젝션
    @Query("SELECT u1.userid, u1.name, u1.age FROM User1 as u1 WHERE u1.userid = :userid")
    public List<Object[]> selectUser1WhereUserid(@Param("userid") String userid);

    // 부모에게...
    @Query("SELECT p, c FROM Parent AS p " +
            "JOIN Child AS c ON p.pid = c.pid " +
            "WHERE p.pid = :pid") // Entity Parent와 Child를 추가하자.
    public List<Object[]> selectParentJoinChild(@Param("pid") String pid);



}
