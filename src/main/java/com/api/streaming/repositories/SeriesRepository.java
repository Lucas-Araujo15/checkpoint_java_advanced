package com.api.streaming.repositories;

import com.api.streaming.models.Series;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {
    Page<Series> findByTitleContainsIgnoreCaseOrGenreContainsIgnoreCaseOrReleasingYear(String title, String genre, int releasingYear, Pageable pagination);
}
