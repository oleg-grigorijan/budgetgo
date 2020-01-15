package com.godev.budgetgo.repository.impl;

import com.godev.budgetgo.entity.Storage;
import com.godev.budgetgo.entity.User;
import com.godev.budgetgo.repository.StoragesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class StoragesRepositoryImpl extends AbstractRepository<Storage, Long> implements StoragesRepository {

    public StoragesRepositoryImpl() {
        super(Storage.class);
    }

    @Override
    public List<Storage> getByUser(User user) {
        return entityManager
                .createQuery("SELECT s FROM Storage s " +
                        "WHERE s IN (SELECT r.storage FROM StorageRelations r WHERE r.user.id = :userId)", entityClass)
                .setParameter("userId", user.getId())
                .getResultList();
    }
}