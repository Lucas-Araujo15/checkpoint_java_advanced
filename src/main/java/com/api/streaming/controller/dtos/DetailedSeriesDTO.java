package com.api.streaming.controller.dtos;

import com.api.streaming.models.Episode;
import com.api.streaming.models.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DetailedSeriesDTO(
        String title,

        String description,

        int releasingYear,

        String genre,

        @JsonIgnoreProperties("series")
        List<Episode> episodeList
) {
    public DetailedSeriesDTO(Series series) {
        this(series.getTitle(), series.getDescription(), series.getReleasingYear(), series.getGenre(), series.getEpisodeList());
    }
}
