package com.godev.budgetgo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSettingsInfoDto {
    private Long id;
    private String login;
    private String email;
    private String name;
    private String surname;
    @JsonProperty("isEmailPublic")
    private Boolean emailPublic;
    @JsonProperty("mainCurrency")
    private CurrencyInfoDto mainCurrencyInfoDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getEmailPublic() {
        return emailPublic;
    }

    public void setEmailPublic(Boolean isEmailPublic) {
        this.emailPublic = isEmailPublic;
    }


    public CurrencyInfoDto getMainCurrencyInfoDto() {
        return mainCurrencyInfoDto;
    }

    public void setMainCurrencyInfoDto(CurrencyInfoDto mainCurrencyInfoDto) {
        this.mainCurrencyInfoDto = mainCurrencyInfoDto;
    }
}
