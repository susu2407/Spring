package kr.co.demo.ch06.dto;

import kr.co.demo.ch06.entity.User1;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User1DTO {

    private String userid;
    private String name;
    private String birth;
    private int age;

    // Entity 변환 메서드 (필요)
    // DTO 변환 메서드 정의를 (복)붙여넣고
    public User1 toEntity() {
        return User1.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .age(age)
                .build();
    }
}
