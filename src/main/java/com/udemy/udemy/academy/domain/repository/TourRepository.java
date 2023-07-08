package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<TourEntity, Long> {

}
