package com.godev.budgetgo.service.request;


import com.godev.budgetgo.dto.UserCreationDto;
import com.godev.budgetgo.dto.UserInfoDto;

import java.util.List;

public interface UsersRequestService {
    UserInfoDto getById(Long id);

    UserInfoDto getByLogin(String login);

    List<UserInfoDto> getAll();

    UserInfoDto create(UserCreationDto creationDto);
}
