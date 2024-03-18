package com.api.streaming.domain.series;

import com.api.streaming.domain.episode.Episode;
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

    @OneToMany
    @JoinColumn(name = "series_id")
    private List<Episode> episodeList;
}
