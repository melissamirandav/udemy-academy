package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.ReservationEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, UUID> {

}
