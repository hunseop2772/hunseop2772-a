package com.koreait.day5.repository;

import com.koreait.day5.model.entity.Category;
import com.koreait.day5.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {


}
