package kr.co.ch07.ch07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SC_USER")
public class User {

    @Id
    private String usid;
    private String pass;
    private String name;
    private int age;
    private String role; // 중요!!

    @CreationTimestamp
    private LocalDateTime regDate;

    // 이제 MyUserDetails를 정의하도록 하자. 고고
}
