package com.api.streaming.controller;

import com.api.streaming.domain.series.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;

public class SeriesController {
    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }
}
