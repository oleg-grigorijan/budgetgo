package com.godev.budgetgo.service.data.implementations;

import com.godev.budgetgo.entity.Storage;
import com.godev.budgetgo.entity.StorageRelations;
import com.godev.budgetgo.entity.UserStorageKey;
import com.godev.budgetgo.exception.StorageRelationsNotFoundException;
import com.godev.budgetgo.repository.StoragesRelationsRepository;
import com.godev.budgetgo.service.data.StoragesDataService;
import com.godev.budgetgo.service.data.StoragesRelationsDataService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
class StoragesRelationsDataServiceImpl
        extends AbstractDataService<StorageRelations, UserStorageKey>
        implements StoragesRelationsDataService {

    private final StoragesRelationsRepository repository;
    private final StoragesDataService storagesDataService;

    public StoragesRelationsDataServiceImpl(
            StoragesRelationsRepository repository,
            StoragesDataService storagesDataService) {
        super(repository, StorageRelationsNotFoundException::new);
        this.repository = repository;
        this.storagesDataService = storagesDataService;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<StorageRelations> findById(UserStorageKey id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StorageRelations> getByStorage(Storage storage) {
        return repository.findByStorage(storage);
    }

    @Transactional
    @Override
    public void delete(StorageRelations entity) {
        super.delete(entity);
        Storage storage = entity.getStorage();
        if (getByStorage(storage).isEmpty()) {
            storagesDataService.delete(storage);
        }
    }
}