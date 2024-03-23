package com.api.streaming.controller.dtos;

import jakarta.validation.constraints.NotNull;

public record EpisodeUpdateDTO(
        String title,

        int episodeNumber
) {
}
