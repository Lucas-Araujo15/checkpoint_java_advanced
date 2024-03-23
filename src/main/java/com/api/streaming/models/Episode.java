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
public class Episode {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int episodeNumber;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    public Episode(EpisodeRegisterDTO episodeRegisterDTO) {
        this.episodeNumber = episodeRegisterDTO.episodeNumber();
        this.title = episodeRegisterDTO.title();
    }

    public void updateInformation(EpisodeUpdateDTO episodeUpdateDTO) {
        if (episodeUpdateDTO.episodeNumber() != 0) {
            this.episodeNumber = episodeUpdateDTO.episodeNumber();
        }

        if (episodeUpdateDTO.title() != null) {
            this.title = episodeUpdateDTO.title();
        }
    }
}
