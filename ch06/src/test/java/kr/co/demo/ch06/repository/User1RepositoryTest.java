package kr.co.demo.ch06.repository;

import kr.co.demo.ch06.entity.Child;
import kr.co.demo.ch06.entity.Parent;
import kr.co.demo.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;

    void findUser1ByUserid() {
        User1 user1 = user1Repository.findUser1ByUserid("a101");
        System.out.println(user1);

    }

    @Test
    void findUser1ByName() {
        List<User1> list = user1Repository.findUser1ByName("김유신");
        System.out.println(list);
    }

    @Test
    void findUser1ByNameNot() {
    }

    @Test
    void findUser1ByUseridAndName() {
    }

    @Test
    void findUser1ByUseridOrName() {
    }

    @Test
    void findUser1ByAgeGreaterThan() {
    }

    @Test
    void findUser1ByAgeGreaterThanEqual() {
    }

    @Test
    void findUser1ByAgeLessThan() {
    }

    @Test
    void findUser1ByAgeLessThanEqual() {
    }

    @Test
    void findUser1ByAgeBetween() {
    }

    @Test
    void findUser1ByNameLike() {
    }

    @Test
    void findUser1ByNameContains() {
    }

    @Test
    void findUser1ByNameStartsWith() {
    }

    @Test
    void findUser1ByNameEndsWith() {
    }

    @Test
    void findUser1ByOrderByName() {
    }

    @Test
    void findUser1ByOrderByAgeAsc() {
    }

    @Test
    void findUser1ByOrderByAgeDesc() {
    }

    @Test
    void findUser1ByAgeGreaterThanOrderByAgeDesc() {
    }

    @Test
    void countUser1ByUserid() {
    }

    @Test
    void countUser1ByName() {
    }


    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private ParentRepository parentRepository;

    @Test
    void selectParentJoinChild() {

        Parent parent = Parent.builder()
                .pid("a101")
                .name("김유신")
                .age(45)
                .build();

        parentRepository.save(parent);

        Child child = Child.builder()
                .cid("c101")
                .pid("a101")
                .name("김철수")
                .age(12)
                .build();

        childRepository.save(child);

        List<Object[]> objectList = user1Repository.selectParentJoinChild("a101");
        System.out.println(objectList);

        for(Object[] object : objectList){

            Parent selectedParent = (Parent) object[0];
            Child selectedChild = (Child) object[1];

            System.out.println(selectedParent);
            System.out.println(selectedChild);
        }

    }
}