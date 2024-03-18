package com.api.streaming.domain.movie;

public record MovieUpdateDTO(
        String title,

        String description,

        int releasingYear,

        String director,

        String genre
) {
}
