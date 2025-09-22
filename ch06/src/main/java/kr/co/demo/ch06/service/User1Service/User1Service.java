package kr.co.demo.ch06.service.User1Service;

import kr.co.demo.ch06.dto.User1DTO;
import kr.co.demo.ch06.entity.User1;
import kr.co.demo.ch06.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public void save(User1DTO user1DTO) {

        // DTO를 Entity로 변환
        User1 user1 = user1DTO.toEntity();

        // save() : JPA 기본 Insert 메서드
        user1Repository.save(user1);
    }
    public User1DTO getUser(String userid) {
        /*
            findeById() : JPA 기본 select 메서드, 반환값은 Oprion 타입
            Optional<엔티티> 타입은 null 체크 검정을 안전하게 처리하기위한 jPA 반환 타입
        */
        Optional<User1> optUser1 = user1Repository.findById(userid);

        // 해당 사용자 Entity가 존재하면 **안전하게 처리하기 위한 검사
        if(optUser1.isPresent()) {
            // 존재하면,
            User1 user1 = optUser1.get(); // User1DTO에서 와서 (어디로)가야될까요? -> Service로!?

            // Entity를 DTO로 변환해서 반환!
            return user1.toDTO();
        }

        // 존재하지 않으면, null 반환
        return null;
    }
    public List<User1DTO> getUsers() {

        // findAll() : JPA 전체 조회 메서드
        List<User1> list = user1Repository.findAll();

//        // DTO 리스트 변환
//        List<User1DTO> dtoList = new ArrayList<>();
//
//        for (User1 user : list) {
//            dtoList.add(user.toDTO());
//        }

        // DTP 리스트 변환 (조금 더 세련된 방법) // java할 때에 배웠는데, 기억아나면 3년 뒤에 이렇게 하셔라.
        List<User1DTO> dtoList = list.stream()
                                        .map(entity->entity.toDTO())
                                        .collect(Collectors.toList());

        return dtoList; //
    }
    public void modify(User1DTO user1DTO) {

        // 수정 대상 Entity 존재 확인
        if(user1Repository.existsById(user1DTO.getUserid())) {

            // DTO를 Entity로 변환
            User1 user1 = user1DTO.toEntity();

            // Entity 수정
            user1Repository.save(user1); // 기존 Entity같은 save()로 수정
        }
    }
    public void delete(String userid) {
        // deleteById() : JPA 기본 삭제 메서드
        user1Repository.deleteById(userid);
    }

}
