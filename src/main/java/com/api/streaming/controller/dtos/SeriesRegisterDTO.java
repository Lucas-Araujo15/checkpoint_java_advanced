package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeriesRegisterDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        int releasingYear,

        @NotBlank
        String genre
) {
}
