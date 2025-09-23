package kr.co.demo.ch06.repository.shop.custom;

import kr.co.demo.ch06.entity.shop.Customer;

import java.util.List;

// QueryDSL을 사용하기 위한 CustomerRepository의 확장 인터페이스
public interface CustomerRepositoryCustom {

    public Customer selectCustomer(String custId);
    public List<Customer> selectAllCustomer();
    public List<Customer> selectProjectionCustomer();




    // 이거는 굳이 작성하지 않는다.
    //public void insertCustomer();
    //public void updateCustomer();
    //public void deleteCustomer();
}
