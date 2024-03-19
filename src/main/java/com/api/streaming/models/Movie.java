package com.api.streaming.models;

import com.api.streaming.controller.dtos.MovieRegisterDTO;
import com.api.streaming.controller.dtos.MovieUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "movies")
@Entity(name= "Movie")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @Column(name = "releasing_year")
    private int releasingYear;

    private String director;
    private String genre;

    public Movie(MovieRegisterDTO movieRegisterDTO) {
        this.description = movieRegisterDTO.description();
        this.director = movieRegisterDTO.director();
        this.genre = movieRegisterDTO.genre();
        this.title = movieRegisterDTO.title();
        this.releasingYear = movieRegisterDTO.releasingYear();
    }

    public void updateInformation(MovieUpdateDTO movieUpdateDTO) {
        if (movieUpdateDTO.description() != null) {
            this.description = movieUpdateDTO.description();
        }

        if (movieUpdateDTO.director() != null) {
            this.director = movieUpdateDTO.director();
        }

        if (movieUpdateDTO.title() != null) {
            this.title = movieUpdateDTO.title();
        }

        if (movieUpdateDTO.genre() != null) {
            this.genre = movieUpdateDTO.genre();
        }

        if (movieUpdateDTO.releasingYear() != 0) {
            this.releasingYear = movieUpdateDTO.releasingYear();
        }
    }
}
