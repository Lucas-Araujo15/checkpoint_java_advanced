package com.api.streaming.controller.dtos;

import com.api.streaming.models.Movie;

public record DetailedMovieDTO(
        String title,
        String description,
        int realisingYear,
        String director,
        String genre
) {
    public DetailedMovieDTO(Movie movie) {
        this(movie.getTitle(), movie.getDescription(), movie.getReleasingYear(), movie.getDirector(), movie.getGenre());
    }
}
