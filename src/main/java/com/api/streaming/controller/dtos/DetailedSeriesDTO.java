package com.api.streaming.controller.dtos;

import com.api.streaming.models.Episode;
import com.api.streaming.models.Season;
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

        int seasonQuantity,

        @JsonIgnoreProperties("series")
        List<DetailedSeasonDTO> seasonList
) {
    public DetailedSeriesDTO(Series series) {
        this(series.getTitle(), series.getDescription(), series.getReleasingYear(), series.getGenre(), series.getSeasonQuantity(), series.getSeasonList().stream().map(DetailedSeasonDTO::new).toList());
    }
}
