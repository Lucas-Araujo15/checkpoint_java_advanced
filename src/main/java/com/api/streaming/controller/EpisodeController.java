package com.api.streaming.controller;

import com.api.streaming.domain.episode.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EpisodeController {
    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }
}
