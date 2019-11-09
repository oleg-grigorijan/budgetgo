package com.godev.budgetgo.service.merger.implementations;

import com.godev.budgetgo.dto.UserSettingsPatchesDto;
import com.godev.budgetgo.entity.User;
import com.godev.budgetgo.service.data.CurrenciesDataService;
import com.godev.budgetgo.service.merger.UsersSettingsMerger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class UsersSettingsMergerImpl implements UsersSettingsMerger {

    private final CurrenciesDataService currenciesDataService;
    private final PasswordEncoder passwordEncoder;

    public UsersSettingsMergerImpl(
            CurrenciesDataService currenciesDataService,
            PasswordEncoder passwordEncoder
    ) {
        this.currenciesDataService = currenciesDataService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User merge(UserSettingsPatchesDto dto, User eOld) {
        User e = eOld.clone();
        if (dto.getLogin() != null) e.setLogin(dto.getLogin());
        if (dto.getEmail() != null) e.setEmail(dto.getEmail());
        if (dto.getName() != null) e.setName(dto.getName());
        if (dto.getSurname() != null) e.setSurname(dto.getSurname());
        if (dto.getPassword() != null) e.setPasswordHash(passwordEncoder.encode(dto.getPassword()));
        if (dto.getEmailPublic() != null) e.setEmailPublic(dto.getEmailPublic());
        if (dto.getMainCurrencyId() != null) e.setMainCurrency(currenciesDataService.getById(dto.getMainCurrencyId()));
        return e;
    }
}