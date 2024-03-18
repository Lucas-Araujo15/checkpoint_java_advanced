package com.api.streaming.domain.episode;

import com.api.streaming.domain.series.Series;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "episodes")
@Entity(name= "Episode")
@Getter
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
}
