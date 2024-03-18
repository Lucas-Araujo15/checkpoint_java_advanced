package com.api.streaming.domain.movie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovieRegisterDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        int releasingYear,

        @NotBlank
        String director,

        @NotBlank
        String genre
) {
}
