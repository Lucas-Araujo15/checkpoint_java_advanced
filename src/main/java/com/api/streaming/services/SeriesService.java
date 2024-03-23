package com.api.streaming.services;

import com.api.streaming.controller.dtos.DetailedSeriesDTO;
import com.api.streaming.controller.dtos.SeriesRegisterDTO;
import com.api.streaming.controller.dtos.SeriesUpdateDTO;
import com.api.streaming.models.Series;
import com.api.streaming.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public Series create(SeriesRegisterDTO seriesRegisterDTO) {
        Series series = new Series(seriesRegisterDTO);

        seriesRepository.save(series);

        return series;
    }

    public Page<DetailedSeriesDTO> list(Pageable pagination) {
        return seriesRepository.findAll(pagination).map(DetailedSeriesDTO::new);
    }

    public DetailedSeriesDTO get(Long id) {
        return new DetailedSeriesDTO(seriesRepository.getReferenceById(id));
    }

    public DetailedSeriesDTO update(Long id, SeriesUpdateDTO seriesUpdateDTO) {
        Series series = seriesRepository.getReferenceById(id);

        series.updateInformation(seriesUpdateDTO);

        seriesRepository.save(series);

        return new DetailedSeriesDTO(series);
    }

    public void delete(Long id) {
        Series series = seriesRepository.getReferenceById(id);
        seriesRepository.delete(series);
    }

    public Page<DetailedSeriesDTO> findByParams(String title, String genre, int releasingYear, int seasonQuantity, Pageable pagination) {
        return seriesRepository.findByTitleContainsIgnoreCaseOrGenreContainsIgnoreCaseOrReleasingYearOrSeasonQuantity(title, genre, releasingYear, seasonQuantity, pagination).map(DetailedSeriesDTO::new);
    }
}
