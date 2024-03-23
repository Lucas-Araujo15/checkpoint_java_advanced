package com.api.streaming.controller;

import com.api.streaming.controller.dtos.DetailedEpisodeDTO;
import com.api.streaming.controller.dtos.EpisodeRegisterDTO;
import com.api.streaming.controller.dtos.EpisodeUpdateDTO;
import com.api.streaming.models.Episode;
import com.api.streaming.services.EpisodeService;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid EpisodeRegisterDTO episodeRegisterDTO, UriComponentsBuilder uriBuilder) throws BadRequestException {
        Episode episode = episodeService.create(episodeRegisterDTO);

        URI uri = uriBuilder.path("/episodes/{id}").buildAndExpand(episode.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailedEpisodeDTO> update(@PathVariable("id") Long id, @RequestBody EpisodeUpdateDTO episodeUpdateDTO) {
        DetailedEpisodeDTO detailedEpisodeDTO = episodeService.update(id, episodeUpdateDTO);
        return ResponseEntity.ok(detailedEpisodeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id) {
        episodeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
