package com.godev.budgetgo.repository;

import com.godev.budgetgo.entity.UserStorageKey;
import com.godev.budgetgo.entity.UserStorageRelations;

import java.util.List;

public interface UsersStoragesRelationsRepository extends Repository<UserStorageRelations, UserStorageKey> {
    List<UserStorageRelations> findByStorageId(Long storageId);
}