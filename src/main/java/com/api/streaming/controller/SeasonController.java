package com.api.streaming.controller;

import com.api.streaming.controller.dtos.*;
import com.api.streaming.models.Season;
import com.api.streaming.models.Series;
import com.api.streaming.services.SeasonService;
import com.api.streaming.services.SeriesService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/season")
public class SeasonController {
    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SeasonRegisterDTO seasonRegisterDTO, UriComponentsBuilder uriBuilder) throws BadRequestException {
        Season season = seasonService.create(seasonRegisterDTO);

        URI uri = uriBuilder.path("/series/{id}").buildAndExpand(season.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedSeasonDTO> update(@PathVariable("id") Long id, @RequestBody SeasonUpdateDTO seasonUpdateDTO) {
        DetailedSeasonDTO detailedSeasonDTO = seasonService.update(id, seasonUpdateDTO);
        return ResponseEntity.ok(detailedSeasonDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        seasonService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
