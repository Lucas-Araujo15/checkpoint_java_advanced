package com.api.streaming.controller.dtos;

import com.api.streaming.models.Episode;
import com.api.streaming.models.Season;
import com.api.streaming.models.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record DetailedSeasonDTO(
        String name,
        int seasonNumber,
        @JsonIgnoreProperties("season")
        List<DetailedEpisodeDTO> episodeList
)
{
    public DetailedSeasonDTO(Season season) {
        this(season.getName(), season.getSeasonNumber(), season.getEpisodeList().stream().map(DetailedEpisodeDTO::new).toList());
    }
}
