package com.service.WasteManagerService.Service;

import com.service.WasteManagerService.Clients.WasteManagerClientRest;
import com.service.WasteManagerService.Dto.WasteManagerAddressDto;
import com.service.WasteManagerService.Dto.WasteManagerDto;
import com.service.WasteManagerService.Entity.WasteCenterAuthorization;
import com.service.WasteManagerService.Entity.WasteManager;
import com.service.WasteManagerService.Entity.WasteManagerAddress;
import com.service.WasteManagerService.IRepository.IWasteManagerRepository;
import com.service.WasteManagerService.IService.IWasteManagerService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WasteManagerService implements IWasteManagerService {
  private final IWasteManagerRepository wasteManagerRepository;

  private final WasteManagerClientRest clientRest;

  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public WasteManager create(WasteManagerDto wasteManagerToAdd) {
    Date currentDate = new Date();
    WasteManager wasteManager = modelMapper.map(
      wasteManagerToAdd,
      WasteManager.class
    );
    wasteManager.setCreatedDate(currentDate);
    wasteManager.setLastModifiedDate(currentDate);

    wasteManager.setWasteCenterAuthorizationEntities(
      wasteManagerToAdd
        .getWasteCenterAuthorizationDto()
        .stream()
        .map(
          authDto -> modelMapper.map(authDto, WasteCenterAuthorization.class)
        )
        .collect(Collectors.toList())
    );

    WasteManager finalWasteManager = wasteManagerRepository.save(wasteManager);
    System.out.println("WasteManager id: " + finalWasteManager.getId());
    Optional
      .ofNullable(wasteManagerToAdd.getWasteManagerAddressDto())
      .ifPresent(
        addressDto -> {
          addressDto.setIdWasteManager(finalWasteManager.getId());

          WasteManagerAddress savedAddressEntity = clientRest
            .create(addressDto)
            .getBody();
          finalWasteManager.setWasteManagerAddressEntity(savedAddressEntity);
        }
      );

    return finalWasteManager;
  }

  @Override
  public WasteManager delete(Long idWasteManager) {
    WasteManager wasteManager = findById(idWasteManager);
    WasteManagerAddress wasteManagerAddress = clientRest
      .getByIdWasteManager(wasteManager.getId())
      .getBody();

    clientRest.delete(wasteManagerAddress.getId());
    wasteManagerRepository.delete(wasteManager);
    return wasteManager;
  }

  @Override
  public WasteManager findById(Long idWasteManager) {
    return wasteManagerRepository
      .findById(idWasteManager)
      .map(
        wasteManager -> {
          wasteManager.setWasteManagerAddressEntity(
            clientRest.getByIdWasteManager(wasteManager.getId()).getBody()
          );
          return wasteManager;
        }
      )
      .orElseThrow(
        () ->
          new EntityNotFoundException(
            "WASTE MANAGER WITH ID: " + idWasteManager + " NOT_FOUND"
          )
      );
  }

  @Override
  public WasteManager update(
    Long idWasteManager,
    WasteManagerDto wasteManagerToUpdate
  ) {
    WasteManager wasteManager = findById(idWasteManager);
    WasteManagerAddressDto addressDto = modelMapper.map(
      wasteManager.getWasteManagerAddressEntity(),
      WasteManagerAddressDto.class
    );
    addressDto =
      modelMapper.map(
        wasteManagerToUpdate.getWasteManagerAddressDto(),
        WasteManagerAddressDto.class
      );
    WasteManagerAddress wasteManagerAddress = clientRest
      .update(wasteManager.getWasteManagerAddressEntity().getId(), addressDto)
      .getBody();
    modelMapper.map(wasteManagerToUpdate, wasteManager);
    wasteManager.setWasteManagerAddressEntity(wasteManagerAddress);
    Date currentDate = new Date();
    wasteManager.setLastModifiedDate(currentDate);

    wasteManager.getWasteCenterAuthorizationEntities().clear();
    wasteManagerToUpdate
      .getWasteCenterAuthorizationDto()
      .forEach(
        authDto -> {
          WasteCenterAuthorization authorization = modelMapper.map(
            authDto,
            WasteCenterAuthorization.class
          );
          wasteManager.getWasteCenterAuthorizationEntities().add(authorization);
        }
      );
    return wasteManagerRepository.save(wasteManager);
  }

  @Override
  public List<WasteManager> get() {
    List<WasteManager> wasteManagers = wasteManagerRepository.findAll(
      Sort.by(Sort.Direction.DESC, "name")
    );
    wasteManagers.forEach(
      wasteManager -> {
        WasteManagerAddress address = clientRest
          .getByIdWasteManager(wasteManager.getId())
          .getBody();
        wasteManager.setWasteManagerAddressEntity(address);
      }
    );
    return wasteManagers;
  }
}
