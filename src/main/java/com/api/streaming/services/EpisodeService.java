package com.api.streaming.services;

import com.api.streaming.controller.dtos.DetailedEpisodeDTO;
import com.api.streaming.controller.dtos.EpisodeRegisterDTO;
import com.api.streaming.controller.dtos.EpisodeUpdateDTO;
import com.api.streaming.models.Episode;
import com.api.streaming.models.Series;
import com.api.streaming.repositories.SeriesRepository;
import com.api.streaming.repositories.EpisodeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    public Episode create(EpisodeRegisterDTO episodeRegisterDTO) throws BadRequestException {

        if (!seriesRepository.existsById(episodeRegisterDTO.seriesId())) {
            throw new BadRequestException("A série informada não existe");
        }

        Episode episode = new Episode(episodeRegisterDTO);
        Series series = seriesRepository.getReferenceById(episodeRegisterDTO.seriesId());

        episode.setSeries(series);

        episodeRepository.save(episode);

        return episode;
    }

    public DetailedEpisodeDTO get (Long id) {
        return new DetailedEpisodeDTO(episodeRepository.getReferenceById(id));
    }

    public DetailedEpisodeDTO update(Long id, EpisodeUpdateDTO episodeUpdateDTO) {
        Episode episode = episodeRepository.getReferenceById(id);

        episode.updateInformation(episodeUpdateDTO);

        episodeRepository.save(episode);

        return new DetailedEpisodeDTO(episode);
    }

    public void delete(Long id) {
        Episode episode = episodeRepository.getReferenceById(id);
        episodeRepository.delete(episode);
    }
}
