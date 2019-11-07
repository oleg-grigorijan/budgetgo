package com.godev.budgetgo.service.request;

import com.godev.budgetgo.dto.StorageSettingsInfoDto;
import com.godev.budgetgo.dto.StorageSettingsPatchesDto;

public interface StorageSettingsRequestService {
    StorageSettingsInfoDto getByStorageId(Long storageId);

    StorageSettingsInfoDto patch(Long storageId, StorageSettingsPatchesDto patchesDto);
}
