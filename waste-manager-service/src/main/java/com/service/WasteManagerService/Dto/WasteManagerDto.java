package com.service.WasteManagerService.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WasteManagerDto {
  @Pattern(
    regexp = "^[a-zA-Z0-9\\-_]+$",
    message = "Allowed only characters are letters, numbers, '-', and '_': is required"
  )
  @NotBlank(message = "Is required it cannot be null or empty")
  private String name;

  @Pattern(
    regexp = "^[A-Z0-9_]+$",
    message = "Allowed only characters are upper case letters, underscore, and numbers: is required"
  )
  @NotBlank(message = "Is required it cannot be null or empty")
  private String nif;

  private Boolean enabled = Boolean.TRUE;

  @Positive(message = "The version has to be a positive value and is required")
  @NotNull(message = "Is required it cannot be null or empty")
  private Long version;

  @NotNull(message = "Is required it cannot be null or empty")
  private WasteManagerAddressDto wasteManagerAddressDto;

  private List<WasteCenterAuthorizationDto> wasteCenterAuthorizationDto = new ArrayList<WasteCenterAuthorizationDto>();
}
