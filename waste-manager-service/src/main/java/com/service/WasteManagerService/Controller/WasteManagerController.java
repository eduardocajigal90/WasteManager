package com.service.WasteManagerService.Controller;

import com.service.WasteManagerService.Dto.WasteManagerDto;
import com.service.WasteManagerService.Entity.WasteManager;
import com.service.WasteManagerService.ErrorHandling.ResponseInfo;
import com.service.WasteManagerService.IService.IWasteManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Tag(description = "Waste Manager endpoints", name = "WASTE MANAGER CONTROLLER")
public class WasteManagerController {
  private final IWasteManagerService wasteManagerService;

  @PostMapping(value = "/create")
  @Operation(
    operationId = "Create Waste Manager",
    summary = "Endpoint to create a waste manager entity while saving a waste manager address through a feign client"
  )
  public ResponseInfo<WasteManager> create(
    @Valid @RequestBody WasteManagerDto wasteManagerDto,
    HttpServletRequest request
  ) {
    return new ResponseInfo<>(
      HttpStatus.CREATED.value(),
      wasteManagerService.create(wasteManagerDto),
      request.getRequestURI(),
      "success"
    );
  }

  @PutMapping(
    value = "/update/{idWasteManager}",
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(
    operationId = "Update WasteManager by id field",
    summary = "Endpoint to update a waste manager entity, in turn updating a waste manager address through a feign client"
  )
  public ResponseInfo<WasteManager> update(
    @PathVariable(name = "idWasteManager") Long idWasteManager,
    @Valid @RequestBody WasteManagerDto wasteManagerDto,
    HttpServletRequest request
  )
    throws Exception {
    return new ResponseInfo<>(
      HttpStatus.OK.value(),
      wasteManagerService.update(idWasteManager, wasteManagerDto),
      request.getRequestURI(),
      "success"
    );
  }

  @GetMapping(value = "/{id}")
  @Operation(
    operationId = "Get Waste Manager by id field",
    summary = "Endpoint to find a waste management entity by finding a waste manager address through a feign client"
  )
  public ResponseEntity<ResponseInfo<WasteManager>> getById(
    final @PathVariable("id") Long idWasteManager,
    final HttpServletRequest request
  ) {
    final ResponseInfo<WasteManager> controllerResponse = new ResponseInfo<>(
      HttpStatus.OK.value(),
      this.wasteManagerService.findById(idWasteManager),
      request.getRequestURI(),
      "success"
    );

    return ResponseEntity.ok(controllerResponse);
  }

  @DeleteMapping(value = "/delete/{id}")
  @Operation(
    operationId = "Delete Waste Manager by id field",
    summary = "Endpoint to delete a waste manager entity, in turn deleting a waste manager address through a feign client"
  )
  public ResponseEntity<ResponseInfo<WasteManager>> delete(
    final @RequestParam("id") Long idWasteManager,
    final HttpServletRequest request
  ) {
    final ResponseInfo<WasteManager> controllerResponse = new ResponseInfo<>(
      HttpStatus.ACCEPTED.value(),
      this.wasteManagerService.delete(idWasteManager),
      request.getRequestURI(),
      "success"
    );

    return ResponseEntity.accepted().body(controllerResponse);
  }

  @GetMapping(value = "/get/all")
  @Operation(
    operationId = "Get all Waste Manager",
    summary = "Endpoint for get information of all Waste Manager"
  )
  public ResponseEntity<ResponseInfo<List<WasteManager>>> getAllWasteManagers(
    HttpServletRequest request
  ) {
    return new ResponseEntity<>(
      new ResponseInfo<>(
        HttpStatus.OK.value(),
        wasteManagerService.get(),
        request.getRequestURI(),
        "success"
      ),
      HttpStatus.OK
    );
  }
}
