package com.api.streaming.domain.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository episodeRepository;
}
