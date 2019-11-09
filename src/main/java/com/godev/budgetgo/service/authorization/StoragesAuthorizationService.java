package com.godev.budgetgo.service.authorization;

import com.godev.budgetgo.entity.Storage;

import java.util.List;

public interface StoragesAuthorizationService {
    List<Storage> getAllAuthorizedEntities();

    void authorizeAccess(Storage entity);

    void authorizeModificationAccess(Storage entity);
}