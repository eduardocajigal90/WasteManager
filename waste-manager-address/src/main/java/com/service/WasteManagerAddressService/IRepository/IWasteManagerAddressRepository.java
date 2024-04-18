package com.service.WasteManagerAddressService.IRepository;
import com.service.WasteManagerAddressService.Entity.WasteManagerAddress;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface IWasteManagerAddressRepository extends
        JpaRepository<WasteManagerAddress, Long> {
                @Query("Select wma from WasteManagerAddress wma where wma.idWasteManager =?1")
                Optional<WasteManagerAddress>findByIdWasteManager(Long idWasteManager);
}