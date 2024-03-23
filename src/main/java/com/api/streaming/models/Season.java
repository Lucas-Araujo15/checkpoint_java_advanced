package com.api.streaming.models;

import com.api.streaming.controller.dtos.SeasonRegisterDTO;
import com.api.streaming.controller.dtos.SeasonUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "seasons")
@Entity(name= "Season")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Season {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int seasonNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id")
    private List<Episode> episodeList;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    public Season(SeasonRegisterDTO seasonRegisterDTO) {
        this.name = seasonRegisterDTO.name();
        this.seasonNumber = seasonRegisterDTO.seasonNumber();

        if (seasonRegisterDTO.episodeList() != null) {
            this.episodeList = seasonRegisterDTO.episodeList().stream().map(Episode::new).toList();
        }
    }

    public void updateInformation(SeasonUpdateDTO seasonUpdateDTO) {
        if (seasonUpdateDTO.name() != null) {
            this.name = seasonUpdateDTO.name();
        }

        if (seasonUpdateDTO.seasonNumber() != 0) {
            this.seasonNumber = seasonUpdateDTO.seasonNumber();
        }
    }
}
