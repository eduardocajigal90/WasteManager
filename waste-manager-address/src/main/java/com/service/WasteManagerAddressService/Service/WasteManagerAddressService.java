package com.service.WasteManagerAddressService.Service;

import com.service.WasteManagerAddressService.Dto.WasteManagerAddressDto;
import com.service.WasteManagerAddressService.Entity.WasteManagerAddress;
import com.service.WasteManagerAddressService.IRepository.IWasteManagerAddressRepository;
import com.service.WasteManagerAddressService.IService.IWasteManagerAddressService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class WasteManagerAddressService implements IWasteManagerAddressService {
  private final IWasteManagerAddressRepository wasteManagerAddressRepository;

  private final ModelMapper modelMapper;

  @Override
  public WasteManagerAddress create(
    WasteManagerAddressDto wasteManagerAddressToAdd
  ) {
    return Optional
      .of(wasteManagerAddressToAdd)
      .map(dto -> modelMapper.map(dto, WasteManagerAddress.class))
      .map(
        wasteManagerAddress -> {
          wasteManagerAddress.setCreatedDate(new Date());
          wasteManagerAddress.setLastModifiedDate(new Date());
          return wasteManagerAddressRepository.save(wasteManagerAddress);
        }
      )
      .orElseThrow(
        () ->
          new IllegalArgumentException("WasteManagerAddressDto cannot be null")
      );
  }

  @Override
  public WasteManagerAddress delete(Long idWasteManagerAddress) {
    final WasteManagerAddress WasteManagerAddress = findById(
      idWasteManagerAddress
    );
    wasteManagerAddressRepository.delete(WasteManagerAddress);
    return WasteManagerAddress;
  }

  @Override
  public WasteManagerAddress findById(Long idWasteManagerAddress) {
    return wasteManagerAddressRepository
      .findById(idWasteManagerAddress)
      .orElseThrow(
        () ->
          new EntityNotFoundException(
            "WASTE MANAGER WITH ID: " + idWasteManagerAddress + " NOT_FOUND"
          )
      );
  }

  @Override
  public WasteManagerAddress update(
    Long idWasteManagerAddress,
    WasteManagerAddressDto wasteManagerAddressToUpdate
  ) {
    WasteManagerAddress existingWasteManagerAddress = findById(
      idWasteManagerAddress
    );
    modelMapper.map(wasteManagerAddressToUpdate, existingWasteManagerAddress);
    existingWasteManagerAddress.setLastModifiedDate(new Date());
    return wasteManagerAddressRepository.save(existingWasteManagerAddress);
  }

  @Override
  public List<WasteManagerAddress> get() {
    return wasteManagerAddressRepository.findAll();
  }

  @Override
  public WasteManagerAddress findByIdWasteManager(Long idWasteManager) {
    return wasteManagerAddressRepository
      .findByIdWasteManager(idWasteManager)
      .orElseThrow(
        () ->
          new EntityNotFoundException(
            "WASTE MANAGER WITH ID: " + idWasteManager + " NOT_FOUND"
          )
      );
  }
}
