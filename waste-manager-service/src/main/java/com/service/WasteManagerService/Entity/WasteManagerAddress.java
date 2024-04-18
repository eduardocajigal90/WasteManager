package com.service.WasteManagerService.Entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WasteManagerAddress {
  private Long id;
  private String address;
  private Boolean enabled;
  private Long version;
  private Date createdDate;
  private Date lastModifiedDate;
  private Long idWasteManager;
}
