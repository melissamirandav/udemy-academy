package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.HotelEntity;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

  Set<HotelEntity> findByPriceLessThan (float price);
  Set<HotelEntity> findByPriceBetween (float min, float max);
  Set<HotelEntity> findByRatingGreaterThan (int rating);

  Optional<HotelEntity>findByReservationId (UUID id);

}
