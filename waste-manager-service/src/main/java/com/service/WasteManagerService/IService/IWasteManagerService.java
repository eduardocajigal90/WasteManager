package com.service.WasteManagerService.IService;

import com.service.WasteManagerService.Dto.WasteManagerDto;
import com.service.WasteManagerService.Entity.WasteManager;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IWasteManagerService {

    WasteManager create(WasteManagerDto wasteManagerToAdd);

    WasteManager delete(Long idWasteManager);

    WasteManager findById(Long idWasteManager);

    WasteManager update(Long idWasteManager, WasteManagerDto wasteManagerToUpdate);

    List<WasteManager> get();

}
