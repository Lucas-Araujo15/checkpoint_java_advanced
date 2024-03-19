package com.api.streaming.controller.dtos;

import com.api.streaming.models.Episode;
import com.api.streaming.models.Series;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public record DetailedEpisodeDTO(
        String title,
        int episodeNumber,
        int season,

        @JsonIgnoreProperties("episodeList")
        Series series
) {
    public DetailedEpisodeDTO(Episode episode) {
        this(episode.getTitle(), episode.getEpisodeNumber(), episode.getSeason(), episode.getSeries());
    }
}
