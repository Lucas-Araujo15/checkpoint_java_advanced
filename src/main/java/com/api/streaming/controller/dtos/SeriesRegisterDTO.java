package com.api.streaming.controller.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record SeriesRegisterDTO(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        int releasingYear,

        @NotBlank
        String genre,

        @Valid
        @NotNull
        List<SeasonRegisterDTO> seasonList
) {
}
