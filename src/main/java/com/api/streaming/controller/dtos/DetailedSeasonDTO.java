package com.api.streaming.controller.dtos;

import com.api.streaming.models.Season;

public record DetailedSeasonDTO(String name, int seasonNumber) {
    public DetailedSeasonDTO(Season season) {
        this(season.getName(), season.getSeasonNumber());
    }
}
