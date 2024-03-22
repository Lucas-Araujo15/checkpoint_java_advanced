package com.api.streaming.controller.dtos;

import com.api.streaming.models.Episode;
import com.api.streaming.models.Season;
import com.api.streaming.models.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record DetailedEpisodeDTO(
        String title,
        int episodeNumber,
        @JsonIgnoreProperties("episodeList")
        Season season
) {
    public DetailedEpisodeDTO(Episode episode) {
        this(episode.getTitle(), episode.getEpisodeNumber(), episode.getSeason());
    }
}
