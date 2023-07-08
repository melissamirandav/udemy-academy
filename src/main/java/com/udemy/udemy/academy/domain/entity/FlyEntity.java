package com.udemy.udemy.academy.domain.entity;

import com.udemy.udemy.academy.util.Aeroline;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "fly")
public class FlyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "origin_lat")
  private Double originLat;

  @Column(name = "origin_lng")
  private Double originLng;

  @Column(name = "destiny_lng")
  private Double destinyLng;

  @Column(name = "destiny_lat")
  private Double destinyLat;

  @Column(name = "origin_name")
  private String originName;

  @Column(name = "destiny_name")
  private String destinyName;

  @Enumerated(EnumType.STRING)
  @Column(name = "aero_line")
  private Aeroline aeroLine;

  private float price;
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(
      mappedBy = "fly",
      cascade = CascadeType.ALL,
      fetch = FetchType.EAGER,
      orphanRemoval = true
  )
  private List<TicketEntity>ticketEntities;

}
