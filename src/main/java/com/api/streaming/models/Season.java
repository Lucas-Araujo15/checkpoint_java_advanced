package com.api.streaming.models;

import com.api.streaming.controller.dtos.SeasonRegisterDTO;
import com.api.streaming.controller.dtos.SeasonUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "seasons")
@Entity(name= "Season")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
