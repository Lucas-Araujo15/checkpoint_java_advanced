package com.api.streaming.controller;

import com.api.streaming.domain.episode.EpisodeRegisterDTO;
import com.api.streaming.domain.episode.EpisodeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EpisodeRegisterDTO episodeRegisterDTO) {
        return null;
    }
}
