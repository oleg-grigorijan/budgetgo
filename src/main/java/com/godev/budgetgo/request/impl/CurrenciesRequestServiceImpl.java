package com.godev.budgetgo.request.impl;

import com.godev.budgetgo.converter.CurrenciesConverter;
import com.godev.budgetgo.data.CurrenciesDataService;
import com.godev.budgetgo.dto.CurrencyCreationDto;
import com.godev.budgetgo.dto.CurrencyInfoDto;
import com.godev.budgetgo.dto.CurrencyPatchesDto;
import com.godev.budgetgo.entity.Currency;
import com.godev.budgetgo.request.CurrenciesRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrenciesRequestServiceImpl implements CurrenciesRequestService {

    private final CurrenciesDataService dataService;
    private final CurrenciesConverter converter;

    public CurrenciesRequestServiceImpl(CurrenciesDataService dataService, CurrenciesConverter converter) {
        this.dataService = dataService;
        this.converter = converter;
    }

    @Transactional(readOnly = true)
    @Override
    public CurrencyInfoDto getById(Long id) {
        Currency entity = dataService.getById(id);
        return converter.convertToDto(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CurrencyInfoDto> getAll() {
        return converter.convertToDtos(dataService.getAll());
    }

    @Transactional
    @Override
    public CurrencyInfoDto create(CurrencyCreationDto creationDto) {
        Currency entity = converter.convertToEntity(creationDto);
        Currency savedEntity = dataService.add(entity);
        return converter.convertToDto(savedEntity);
    }

    @Transactional
    @Override
    public CurrencyInfoDto patch(Long id, CurrencyPatchesDto patchesDto) {
        Currency entity = dataService.getById(id);
        Currency patchedEntity = converter.merge(entity, patchesDto);
        Currency savedEntity = dataService.update(patchedEntity);
        return converter.convertToDto(savedEntity);
    }
}