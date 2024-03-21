package com.api.streaming.controller;

import com.api.streaming.controller.dtos.SeasonRegisterDTO;
import com.api.streaming.services.SeasonService;
import com.api.streaming.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/season")
public class SeasonController {
    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    public ResponseEntity<?> create(SeasonRegisterDTO seasonRegisterDTO) {

    }
}
