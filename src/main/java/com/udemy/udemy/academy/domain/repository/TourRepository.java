package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.TourEntity;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<TourEntity, Long> {

}
