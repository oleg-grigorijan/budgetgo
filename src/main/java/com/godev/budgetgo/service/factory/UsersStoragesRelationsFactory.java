package com.godev.budgetgo.service.factory;

import com.godev.budgetgo.dto.UserStorageRelationsCreationDto;
import com.godev.budgetgo.entity.Storage;
import com.godev.budgetgo.entity.UserStorageRelations;

public interface UsersStoragesRelationsFactory
        extends ConverterFactory<UserStorageRelationsCreationDto, UserStorageRelations> {

    UserStorageRelations generateCreatorEntityForStorage(Storage storage);
}
