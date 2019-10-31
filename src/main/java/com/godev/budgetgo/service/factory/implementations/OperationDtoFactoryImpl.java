package com.godev.budgetgo.service.factory.implementations;

import com.godev.budgetgo.dto.OperationInfoDto;
import com.godev.budgetgo.entity.Operation;
import com.godev.budgetgo.service.factory.CategoryDtoFactory;
import com.godev.budgetgo.service.factory.OperationDtoFactory;
import com.godev.budgetgo.service.factory.StorageDtoFactory;
import com.godev.budgetgo.service.factory.UserDtoFactory;
import org.springframework.stereotype.Service;

@Service
class OperationDtoFactoryImpl implements OperationDtoFactory {
    private final StorageDtoFactory storageDtoFactory;
    private final CategoryDtoFactory categoryDtoFactory;
    private final UserDtoFactory userDtoFactory;

    public OperationDtoFactoryImpl(
            StorageDtoFactory storageDtoFactory,
            CategoryDtoFactory categoryDtoFactory,
            UserDtoFactory userDtoFactory) {
        this.storageDtoFactory = storageDtoFactory;
        this.categoryDtoFactory = categoryDtoFactory;
        this.userDtoFactory = userDtoFactory;
    }

    @Override
    public OperationInfoDto createFrom(Operation e) {
        OperationInfoDto dto = new OperationInfoDto();
        dto.setId(e.getId());
        dto.setStorageInfoDto(storageDtoFactory.createFrom(e.getStorage()));
        dto.setCategoryInfoDto(categoryDtoFactory.createFrom(e.getCategory()));
        dto.setMoneyDelta(e.getMoneyDelta());
        dto.setDate(e.getDate());
        dto.setDescription(e.getDescription());
        dto.setDateCreated(e.getDateCreated());
        dto.setDateModified(e.getDateModified());
        dto.setLastEditorInfoDto(userDtoFactory.createFrom(e.getLastEditor()));
        dto.setCreatorInfoDto(userDtoFactory.createFrom(e.getCreator()));
        return dto;
    }
}