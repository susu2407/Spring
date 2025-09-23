package kr.co.demo.ch06.dto;

import kr.co.demo.ch06.entity.shop.Product;
import lombok.Data;

@Data
public class ProductAggDTO {

    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;

}
