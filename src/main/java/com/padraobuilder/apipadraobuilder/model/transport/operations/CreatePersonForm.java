package com.padraobuilder.apipadraobuilder.model.transport.operations;

import jakarta.validation.constraints.NotBlank;

public record CreatePersonForm(@NotBlank String name,
                               @NotBlank String email,
                               @NotBlank String phone,
                               @NotBlank String password) {
}
