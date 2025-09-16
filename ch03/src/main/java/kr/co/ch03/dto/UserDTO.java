package kr.co.ch03.dto;

import lombok.*;

@Getter
@Setter
@ToString           // 각 속성의 내용 출력
@NoArgsConstructor  // 기본 생성자(arg가 없는!, ~~가 없는!, ~~~가 없는!)
@AllArgsConstructor
@Builder            // ???
public class UserDTO {

    private String uid;
    private String name;
    private String birth;
    private int age;







}
