package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeriesUpdateDTO(
        String title,

        String description,

        int releasingYear,

        String genre
) {
}
