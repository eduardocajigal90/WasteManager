package com.service.WasteManagerService.Entity;

import jakarta.persistence.*;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "waste_manager")
@Entity
public class WasteManager {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String nif;

  @Transient
  private WasteManagerAddress wasteManagerAddressEntity;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "id_waste_manager")
  private List<WasteCenterAuthorization> wasteCenterAuthorizationEntities = new ArrayList<>();

  private Boolean enable = Boolean.TRUE;
  private Long version = 0L;
  private Date createdDate;
  private Date lastModifiedDate;
}
