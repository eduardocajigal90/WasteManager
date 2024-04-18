package com.service.WasteManagerAddressService.Entity;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_manager_address")
@Entity
public class WasteManagerAddress {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String address;
  private Boolean enabled = Boolean.TRUE;
  private Long version = 0L;
  private Date createdDate;
  private Date lastModifiedDate;
  private Long idWasteManager;
}
