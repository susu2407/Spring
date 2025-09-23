package kr.co.demo.ch06.entity.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_CUSTOMER")
public class Customer {

    @Id
    private String custId;
    private String name;
    private int age;
    private String addr;

    @CreationTimestamp
    private LocalDateTime regDate;

    // 추가 필드
    @Transient // (컬럼에서 제외)
    private int orderCount;

}
