package com.api.streaming.controller.dtos;

public record MovieUpdateDTO(
        String title,

        String description,

        int releasingYear,

        String director,

        String genre
) {
}
