package com.api.streaming.models;

import com.api.streaming.controller.dtos.SeriesRegisterDTO;
import com.api.streaming.controller.dtos.SeriesUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "series")
@Entity(name= "Series")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Series {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @Column(name = "releasing_year")
    private int releasingYear;

    private String genre;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private List<Episode> episodeList;

    public Series(SeriesRegisterDTO seriesRegisterDTO) {
        this.title = seriesRegisterDTO.title();
        this.description = seriesRegisterDTO.description();
        this.releasingYear = seriesRegisterDTO.releasingYear();
        this.genre = seriesRegisterDTO.genre();
    }

    public void updateInformation (SeriesUpdateDTO seriesUpdateDTO) {
        if (seriesUpdateDTO.description() != null) {
            this.description = seriesUpdateDTO.description();
        }

        if (seriesUpdateDTO.title() != null) {
            this.title = seriesUpdateDTO.title();
        }

        if (seriesUpdateDTO.genre() != null) {
            this.genre = seriesUpdateDTO.genre();
        }

        if (seriesUpdateDTO.releasingYear() != 0) {
            this.releasingYear = seriesUpdateDTO.releasingYear();
        }
    }
}
