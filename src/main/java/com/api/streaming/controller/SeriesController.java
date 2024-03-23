package com.api.streaming.controller;

import com.api.streaming.controller.dtos.DetailedMovieDTO;
import com.api.streaming.controller.dtos.DetailedSeriesDTO;
import com.api.streaming.controller.dtos.SeriesRegisterDTO;
import com.api.streaming.controller.dtos.SeriesUpdateDTO;
import com.api.streaming.models.Movie;
import com.api.streaming.models.Series;
import com.api.streaming.services.SeriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private final SeriesService seriesService;

    @Autowired
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid SeriesRegisterDTO seriesRegisterDTO, UriComponentsBuilder uriBuilder) {
        Series series = seriesService.create(seriesRegisterDTO);

        URI uri = uriBuilder.path("/series/{id}").buildAndExpand(series.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DetailedSeriesDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<DetailedSeriesDTO> page = seriesService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedSeriesDTO> get(@PathVariable("id") Long id) {
        DetailedSeriesDTO detailedSeriesDTO = seriesService.get(id);
        return ResponseEntity.ok(detailedSeriesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedSeriesDTO> update(@PathVariable("id") Long id, @RequestBody SeriesUpdateDTO seriesUpdateDTO) {
        DetailedSeriesDTO detailedSeriesDTO = seriesService.update(id, seriesUpdateDTO);
        return ResponseEntity.ok(detailedSeriesDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        seriesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DetailedSeriesDTO>> findByParams(@RequestParam(required = false) String title, @RequestParam(required = false) String genre, @RequestParam(required = false, defaultValue = "0") int releasingYear, @RequestParam(required = false, defaultValue = "0") int seasonQuantity, @PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<DetailedSeriesDTO> detailedSeriesDTOList = seriesService.findByParams(title, genre, Integer.parseInt(String.valueOf(releasingYear)), seasonQuantity, pagination);
        return ResponseEntity.ok(detailedSeriesDTOList);
    }
}
