package com.service.WasteManagerService.Clients;

import com.service.WasteManagerService.Dto.WasteManagerAddressDto;
import com.service.WasteManagerService.Entity.WasteManagerAddress;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "waste-manager-address-service")
public interface WasteManagerClientRest {
  @GetMapping(value = "/get/all")
  public ResponseEntity<List<WasteManagerAddress>> getAllWasteManagerAddress();

  @GetMapping(value = "/{id}")
  public ResponseEntity<WasteManagerAddress> getById(
    @PathVariable("id") Long idWasteManagerAddress
  );

  @PostMapping(value = "/create")
  public ResponseEntity<WasteManagerAddress> create(
    @RequestBody WasteManagerAddressDto wasteManagerAddressDto
  );

  @PutMapping(value = "/update/{id}")
  public ResponseEntity<WasteManagerAddress> update(
    @PathVariable(name = "id") Long id,
    @RequestBody WasteManagerAddressDto wasteManagerAddressDto
  );

  @DeleteMapping(value = "/delete/{id}")
  public ResponseEntity<WasteManagerAddress> delete(
    @PathVariable(name = "id") Long idWasteManagerAddress
  );

  @GetMapping(value = "/get/{id}")
  public ResponseEntity<WasteManagerAddress> getByIdWasteManager(
    @PathVariable("id") Long idWasteManager
  );
}
