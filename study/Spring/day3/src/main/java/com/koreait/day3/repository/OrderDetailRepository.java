package com.koreait.day3.repository;

import com.koreait.day3.model.entity.AdminUser;
import com.koreait.day3.model.entity.Category;
import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {


}
