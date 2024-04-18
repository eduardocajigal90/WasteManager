package com.service.WasteManagerAddressService.Controller;

import com.service.WasteManagerAddressService.Dto.WasteManagerAddressDto;
import com.service.WasteManagerAddressService.Entity.WasteManagerAddress;
import com.service.WasteManagerAddressService.IService.IWasteManagerAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Tag(
  description = "Waste Manager Address endpoints",
  name = "WASTE MANAGER ADDRESS CONTROLLER"
)
public class WasteManagerAddressController {
  private final IWasteManagerAddressService wasteManagerAddressService;

  @PostMapping(value = "/create")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
    operationId = "Create Waste Manager Address",
    summary = "Endpoint to create a waste manager address"
  )
  public ResponseEntity<WasteManagerAddress> create(
    @RequestBody WasteManagerAddressDto WasteManagerAddressDto,
    HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(wasteManagerAddressService.create(WasteManagerAddressDto));
  }

  @PutMapping(
    value = "/update/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseStatus(HttpStatus.OK)
  @Operation(
    operationId = "Update Waste Manager Address by id field",
    summary = "Endpoint to create a waste manager address"
  )
  public ResponseEntity<WasteManagerAddress> update(
    @PathVariable(name = "id") Long idWasteManagerAddress,
    @RequestBody WasteManagerAddressDto wasteManagerAddressDto,
    HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(
        wasteManagerAddressService.update(
          idWasteManagerAddress,
          wasteManagerAddressDto
        )
      );
  }

  @GetMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
    operationId = "Get Waste Manager Address by id field",
    summary = "Endpoint to find a waste manager address"
  )
  public ResponseEntity<WasteManagerAddress> getById(
    final @PathVariable("id") Long idWasteManagerAddress,
    final HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(wasteManagerAddressService.findById(idWasteManagerAddress));
  }

  @DeleteMapping(value = "/delete/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  @Operation(
    operationId = "Delete Waste Manager Address by id field",
    summary = "Endpoint to delete a waste manager address"
  )
  public ResponseEntity<WasteManagerAddress> delete(
    final @PathVariable("id") Long idWasteManagerAddress,
    final HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(wasteManagerAddressService.delete(idWasteManagerAddress));
  }

  @GetMapping(value = "/get/all")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
    operationId = "Get all Waste Manager Address",
    summary = "Endpoint for get information of all Waste Manager Address"
  )
  public ResponseEntity<List<WasteManagerAddress>> getAllWasteManagerAddress(
    HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(wasteManagerAddressService.get());
  }

  @GetMapping(value = "/get/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
    operationId = "Get Waste Manager Address by idWasteManager field",
    summary = "Endpoint to find a waste manager address by idWasteManager"
  )
  public ResponseEntity<WasteManagerAddress> getByIdWasteManager(
    final @PathVariable("id") Long idWasteManager,
    final HttpServletRequest request
  ) {
    return ResponseEntity
      .created(URI.create(request.getRequestURI()))
      .body(wasteManagerAddressService.findByIdWasteManager(idWasteManager));
  }
}
