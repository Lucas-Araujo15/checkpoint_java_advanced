package com.api.streaming.services;

import com.api.streaming.controller.dtos.DetailedMovieDTO;
import com.api.streaming.controller.dtos.MovieRegisterDTO;
import com.api.streaming.controller.dtos.MovieUpdateDTO;
import com.api.streaming.models.Movie;
import com.api.streaming.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie create(MovieRegisterDTO movieRegisterDTO) {
        Movie movie = new Movie(movieRegisterDTO);
        movieRepository.save(movie);

        return movie;
    }

    public Page<DetailedMovieDTO> list(Pageable pagination) {
        return movieRepository.findAll(pagination).map(DetailedMovieDTO::new);
    }

    public DetailedMovieDTO get(Long id) {
        return new DetailedMovieDTO(movieRepository.getReferenceById(id));
    }

    public DetailedMovieDTO update(Long id, MovieUpdateDTO movieUpdateDTO) {
        Movie movie = movieRepository.getReferenceById(id);

        movie.updateInformation(movieUpdateDTO);

        movieRepository.save(movie);

        return new DetailedMovieDTO(movie);
    }

    public void delete(Long id) {
        Movie movie = movieRepository.getReferenceById(id);
        movieRepository.delete(movie);
    }

    public Page<DetailedMovieDTO> findByParams(String title, String genre, int releasingYear, Pageable pagination) {
        return movieRepository.findByTitleContainsIgnoreCaseOrGenreContainsIgnoreCaseOrReleasingYear(title, genre, releasingYear, pagination).map(DetailedMovieDTO::new);
    }
}
