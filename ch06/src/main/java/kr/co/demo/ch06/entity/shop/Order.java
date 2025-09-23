package kr.co.demo.ch06.entity.shop;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "SHOP_ORDER")

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderer")  //FK가 orderer 가 된다.
    private Customer customer;


    private int orderPrice;
    private int orderStatus;

    @CreationTimestamp
    private LocalDateTime orderDate;
}
