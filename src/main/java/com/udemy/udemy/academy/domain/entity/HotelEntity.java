package com.udemy.udemy.academy.domain.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name = "hotel")
public class HotelEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String address;
  private int rating;
  private float price;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true,
      mappedBy = "hotel"
  )
  private Set<ReservationEntity> reservation;

}
