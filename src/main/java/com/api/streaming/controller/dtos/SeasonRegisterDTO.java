package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeasonRegisterDTO(
        @NotBlank
        String name,

        @NotNull
        int seasonNumber,

        @NotNull
        Long seriesId
) {
}
