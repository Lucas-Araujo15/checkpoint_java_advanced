package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EpisodeRegisterDTO(
        @NotBlank
        String title,

        @NotNull
        int episodeNumber,

        Long seasonId
) {
}
