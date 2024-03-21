package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SeasonUpdateDTO(
        String name,

        int seasonNumber
) {
}
