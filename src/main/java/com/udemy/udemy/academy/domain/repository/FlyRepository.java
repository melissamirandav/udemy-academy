package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<FlyEntity, Long> {

}
