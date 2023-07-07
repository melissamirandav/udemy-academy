package com.udemy.udemy.academy.domain.entity;

import com.udemy.udemy.academy.util.Aeroline;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @Column(name = "origin_Ing")
  private Double originIng;

  @Column(name = "destiny_Ing")
  private Double destinyIng;

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

}
