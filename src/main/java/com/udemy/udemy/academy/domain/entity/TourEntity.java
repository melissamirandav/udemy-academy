package com.udemy.udemy.academy.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
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
@Table(name = "tour")

public class TourEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "id_customer")
  private CustomerEntity customer;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "tour",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )

  private List<TicketEntity>ticketEntities;
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "tour",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private  List<ReservationEntity>reservationEntities;

  @PreRemove
  @PrePersist

public void addTicket(TicketEntity ticket){
  if(Objects.isNull(this.ticketEntities)) this.ticketEntities = new ArrayList<>();
  this.ticketEntities.add(ticket);
}

public void remove (UUID id) {
  if(Objects.isNull(this.ticketEntities)) this.ticketEntities = new ArrayList<>();
  this.ticketEntities.removeIf(ticket -> ticket.getId().equals(id));
}

public void updateTickets(){
  if(Objects.isNull(this.ticketEntities)) this.ticketEntities = new ArrayList<>();
  this.ticketEntities.forEach(ticket -> ticket.setTour(this));
}

public void addReservation (ReservationEntity reservation) {
  if(Objects.isNull(this.reservationEntities)) this.reservationEntities = new ArrayList<>();
  this.reservationEntities.add(reservation);
}

public void removeReservation (ReservationEntity reservation) {
  if(Objects.isNull(this.reservationEntities)) this.reservationEntities = new ArrayList<>();
  this.reservationEntities.removeIf(r -> r.getId().equals(reservation));
}

public void updateReservation(){
  this.reservationEntities.forEach(r -> r.setTour(this));
}

}
