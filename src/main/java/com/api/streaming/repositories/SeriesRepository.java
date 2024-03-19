package com.api.streaming.repositories;

import com.api.streaming.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    List<Series> findByTitleContains(String title);
}
