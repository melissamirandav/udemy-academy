package com.udemy.udemy.academy.domain.repository;

import com.udemy.udemy.academy.domain.entity.FlyEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FlyRepository extends JpaRepository<FlyEntity, Long> {

  @Query("select f from fly f where f.price < :price")
  //@Query(value = "select * from fly f where f.price < :price", nativeQuery = true)
  //List<FlyEntity>findByPriceLessThan(Float price);
  List<FlyEntity>selectLessPrice(Float price);

  @Query("select f from fly f where f.price between :min and :max")
  List<FlyEntity>selectBetweenPrice(Float min, Float max);


  @Query("select f from fly f where f.originName = :origin and f.destinyName = :destiny")
  List<FlyEntity>selectOriginDestiny(String origin, String destiny);

  @Query("select f from fly f join fetch f.tickets t where t.id = :id")
  Optional<FlyEntity>findByTicketId(UUID id);
  //Optional<FlyEntity>findByTickestId(UUID id);


}
