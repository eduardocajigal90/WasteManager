package com.service.WasteManagerService.IRepository;

import com.service.WasteManagerService.Entity.WasteManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWasteManagerRepository extends JpaRepository<WasteManager, Long> {
}