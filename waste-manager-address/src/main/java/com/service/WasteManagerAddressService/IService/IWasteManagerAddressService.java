package com.service.WasteManagerAddressService.IService;

import com.service.WasteManagerAddressService.Dto.WasteManagerAddressDto;
import com.service.WasteManagerAddressService.Entity.WasteManagerAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IWasteManagerAddressService {

    WasteManagerAddress create(WasteManagerAddressDto wasteManagerAddressToAdd);

    WasteManagerAddress delete(Long idWasteManagerAddress);

    WasteManagerAddress findById(Long idWasteManagerAddress);

    WasteManagerAddress update(Long idWasteManagerAddress, WasteManagerAddressDto wasteManagerAddressToUpdate);

    List<WasteManagerAddress> get();

    WasteManagerAddress findByIdWasteManager(Long idWasteManager);
}
