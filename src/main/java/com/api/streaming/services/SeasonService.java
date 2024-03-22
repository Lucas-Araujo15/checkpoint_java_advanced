package com.api.streaming.services;

import com.api.streaming.controller.dtos.*;
import com.api.streaming.models.Season;
import com.api.streaming.models.Series;
import com.api.streaming.repositories.MovieRepository;
import com.api.streaming.repositories.SeasonRepository;
import com.api.streaming.repositories.SeriesRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    public Season create(SeasonRegisterDTO seasonRegisterDTO) throws BadRequestException {
        if (!seriesRepository.existsById(seasonRegisterDTO.seriesId())) {
            throw new BadRequestException("A série informada não existe");
        }

        Season season = new Season(seasonRegisterDTO);
        Series series = seriesRepository.getReferenceById(seasonRegisterDTO.seriesId());

        season.setSeries(series);

        seasonRepository.save(season);

        return season;
    }

    public DetailedSeasonDTO update(Long id, SeasonUpdateDTO seasonUpdateDTO) {
        Season season = seasonRepository.getReferenceById(id);

        season.updateInformation(seasonUpdateDTO);

        seasonRepository.save(season);

        return new DetailedSeasonDTO(season);
    }

    public void delete(Long id) {
        Season season = seasonRepository.getReferenceById(id);
        seasonRepository.delete(season);
    }
}
