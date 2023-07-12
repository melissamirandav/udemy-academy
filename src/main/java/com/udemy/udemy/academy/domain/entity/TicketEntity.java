package com.udemy.udemy.academy.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity(name = "ticket")
public class TicketEntity {
  @Id
  private UUID id;

  private float price;

  @Column(name = "departure_date")
  private LocalDate departureDate;

  @Column(name = "arrival_date")
  private LocalDate arrivalDate;

  @Column(name = "purchase_date")
  private LocalDate purchaseDate;

  @ManyToOne
  @JoinColumn(name = "fly_id")
  private FlyEntity fly;

  @ManyToOne
  @JoinColumn(name = "tour_id", nullable = true)
  private TourEntity tour;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerEntity customer;

}
