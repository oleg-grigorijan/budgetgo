package com.godev.budgetgo.service.request.implementations;

import com.godev.budgetgo.auth.AuthenticationFacade;
import com.godev.budgetgo.dto.StorageCreationDto;
import com.godev.budgetgo.dto.StorageInfoDto;
import com.godev.budgetgo.dto.StoragePatchesDto;
import com.godev.budgetgo.entity.Storage;
import com.godev.budgetgo.entity.User;
import com.godev.budgetgo.service.authorization.StoragesAuthorizationService;
import com.godev.budgetgo.service.data.StoragesDataService;
import com.godev.budgetgo.service.factory.StorageDtoFactory;
import com.godev.budgetgo.service.factory.StoragesFactory;
import com.godev.budgetgo.service.merger.StoragesMerger;
import com.godev.budgetgo.service.request.StoragesRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class StoragesRequestServiceImpl
        extends AbstractRequestService<Storage, Long, StorageInfoDto, StorageCreationDto, StoragePatchesDto>
        implements StoragesRequestService {

    private final StoragesDataService dataService;
    private final StoragesFactory entitiesFactory;
    private final StorageDtoFactory dtoFactory;
    private final AuthenticationFacade authenticationFacade;

    public StoragesRequestServiceImpl(
            StoragesDataService dataService,
            StoragesFactory entitiesFactory,
            StorageDtoFactory dtoFactory,
            StoragesMerger merger,
            StoragesAuthorizationService authorizationService,
            AuthenticationFacade authenticationFacade
    ) {
        super(dataService, entitiesFactory, dtoFactory, merger, authorizationService);
        this.dataService = dataService;
        this.entitiesFactory = entitiesFactory;
        this.dtoFactory = dtoFactory;
        this.authenticationFacade = authenticationFacade;
    }

    @Transactional
    @Override
    public StorageInfoDto create(StorageCreationDto creationDto) {
        // TODO: Validation
        User creator = authenticationFacade.getAuthenticatedUser();
        Storage entity = dataService.addWithCreator(
                entitiesFactory.createFrom(creationDto),
                creator
        );
        return dtoFactory.createFrom(entity);
    }
}