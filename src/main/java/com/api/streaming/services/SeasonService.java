package com.api.streaming.services;

import com.api.streaming.controller.dtos.*;
import com.api.streaming.models.Season;
import com.api.streaming.models.Series;
import com.api.streaming.repositories.MovieRepository;
import com.api.streaming.repositories.SeasonRepository;
import com.api.streaming.repositories.SeriesRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    public Season create(SeasonRegisterDTO seasonRegisterDTO) throws BadRequestException {
        System.out.println(seasonRegisterDTO);
        if (!seriesRepository.existsById(seasonRegisterDTO.seriesId())) {
            throw new BadRequestException("A série informada não existe");
        }

        Season season = new Season(seasonRegisterDTO);
        Series series = seriesRepository.getReferenceById(seasonRegisterDTO.seriesId());

        season.setSeries(series);

        series.setSeasonQuantity(series.getSeasonQuantity() + 1);

        seasonRepository.save(season);
        seriesRepository.save(series);

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

        Series series = season.getSeries();

        series.setSeasonQuantity(series.getSeasonQuantity() - 1);

        seriesRepository.save(series);
        seasonRepository.delete(season);
    }
}
