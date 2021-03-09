package ru.mirea.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class SignUpRequest {
    @NotNull
    @NotEmpty
    private final String username;
    @NotNull
    @NotEmpty
    private final String password;
    private final String matchingPassword;
}
