package com.service.WasteManagerService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_center_authorization")
@Entity
public class WasteCenterAuthorization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "authorization_number")
  private String authorizationNumber;
}
