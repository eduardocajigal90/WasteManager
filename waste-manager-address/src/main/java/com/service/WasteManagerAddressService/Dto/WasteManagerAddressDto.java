package com.service.WasteManagerAddressService.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WasteManagerAddressDto {
  @Pattern(
    regexp = "^[a-zA-Z0-9\\-_]+$",
    message = "Allowed only characters are letters, numbers, '-', and '_': is required"
  )
  @NotBlank(message = "Is required it cannot be null or empty")
  private String address;

  private Boolean enabled = Boolean.TRUE;

  @Positive(message = "The version has to be a positive value and is required")
  @NotNull(message = "Is required it cannot be null or empty")
  private Long version;

  //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Long idWasteManager;
}
