package com.service.WasteManagerService.Dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WasteCenterAuthorizationDto {
  @NotBlank(message = "Is required it cannot be null or empty")
  private String authorizationNumber;

  @JsonCreator
  public WasteCenterAuthorizationDto(
    @JsonProperty("authorizationNumber") String authorizationNumber
  ) {
    this.authorizationNumber = authorizationNumber;
  }
}
