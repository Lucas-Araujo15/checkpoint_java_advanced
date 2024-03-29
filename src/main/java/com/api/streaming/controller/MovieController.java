package com.api.streaming.controller;

import com.api.streaming.controller.dtos.DetailedMovieDTO;
import com.api.streaming.controller.dtos.MovieRegisterDTO;
import com.api.streaming.controller.dtos.MovieUpdateDTO;
import com.api.streaming.models.Movie;
import com.api.streaming.services.MovieService;
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
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid MovieRegisterDTO movieRegisterDTO, UriComponentsBuilder uriBuilder) {
        Movie movie = movieService.create(movieRegisterDTO);

        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(movie.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DetailedMovieDTO>> list(@PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<DetailedMovieDTO> page = movieService.list(pagination);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedMovieDTO> get(@PathVariable("id") Long id) {
        DetailedMovieDTO detailedMovieDTO = movieService.get(id);
        return ResponseEntity.ok(detailedMovieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedMovieDTO> update(@PathVariable("id") Long id, @RequestBody MovieUpdateDTO movieUpdateDTO) {
        DetailedMovieDTO detailedMovieDTO = movieService.update(id, movieUpdateDTO);
        return ResponseEntity.ok(detailedMovieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DetailedMovieDTO>> findByParams(@RequestParam(required = false) String title, @RequestParam(required = false) String genre, @RequestParam(required = false, defaultValue = "0") String releasingYear, @PageableDefault(size = 10, page = 0) Pageable pagination) {
        Page<DetailedMovieDTO> detailedMovieDTOList = movieService.findByParams(title, genre, Integer.parseInt(releasingYear), pagination);
        return ResponseEntity.ok(detailedMovieDTOList);
    }
}
