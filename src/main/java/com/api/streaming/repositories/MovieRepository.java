package com.api.streaming.repositories;

import com.api.streaming.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findByTitleContainsIgnoreCaseOrGenreContainsIgnoreCaseOrReleasingYear(String title, String genre, int releasingYear, Pageable pagination);
}
