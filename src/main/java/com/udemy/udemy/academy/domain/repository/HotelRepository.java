package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

}
