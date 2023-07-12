package com.udemy.udemy.academy.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
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

@Entity
@Table(name = "customer")

public class CustomerEntity {
  @Id
  private String dni;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "credit_card")
  private String creditCard;

  @Column(name = "total_flights")
  private int totalFlights;

  @Column(name = "total_lodgings")
  private int totalLodgings;

  @Column(name = "total_tours")
  private int totalTours;

  @Column (name = "phone_number")
  private String phoneNumber;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "customer",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private List<TicketEntity>ticketEntities;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "customer",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private List<TourEntity>tourEntities;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "customer",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private List<ReservationEntity>reservationEntities;
}
