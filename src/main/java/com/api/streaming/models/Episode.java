package com.api.streaming.models;

import com.api.streaming.controller.dtos.EpisodeRegisterDTO;
import com.api.streaming.controller.dtos.EpisodeUpdateDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "episodes")
@Entity(name= "Episode")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Episode {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int episodeNumber;
    private int season;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    public Episode(EpisodeRegisterDTO episodeRegisterDTO) {
        this.episodeNumber = episodeRegisterDTO.episodeNumber();
        this.season = episodeRegisterDTO.season();
        this.title = episodeRegisterDTO.title();
    }

    public void updateInformation(EpisodeUpdateDTO episodeUpdateDTO) {
        if (episodeUpdateDTO.episodeNumber() != 0) {
            this.episodeNumber = episodeUpdateDTO.episodeNumber();
        }

        if (episodeUpdateDTO.season() != 0) {
            this.season = episodeUpdateDTO.season();
        }

        if (episodeUpdateDTO.title() != null) {
            this.title = episodeUpdateDTO.title();
        }
    }
}
