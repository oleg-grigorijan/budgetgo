package com.godev.budgetgo.controller;

import com.godev.budgetgo.dto.CurrencyCreationDto;
import com.godev.budgetgo.dto.CurrencyInfoDto;
import com.godev.budgetgo.dto.CurrencyPatchesDto;
import com.godev.budgetgo.request.CurrenciesRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesController {

    private final CurrenciesRequestService requestService;

    public CurrenciesController(CurrenciesRequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CurrencyInfoDto> getAll() {
        return requestService.getAll();
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyInfoDto create(HttpServletResponse response, @RequestBody @Valid CurrencyCreationDto creationDto) {
        CurrencyInfoDto createdDto = requestService.create(creationDto);
        response.addHeader("Location", "/api/currencies/" + createdDto.getId());
        return createdDto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyInfoDto get(@PathVariable Long id) {
        return requestService.getById(id);
    }

    @PatchMapping("/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyInfoDto patch(@PathVariable Long id, @RequestBody @Valid CurrencyPatchesDto patchesDto) {
        return requestService.patch(id, patchesDto);
    }
}
