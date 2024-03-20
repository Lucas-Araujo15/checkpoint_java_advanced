package com.api.streaming.repositories;

import com.api.streaming.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("""
            select m from Movie m
            where m.title like %:title%
            and m.genre like %:genre%
            and m.releasingYear = :releasingYear
            """)
    List<Movie> findByParams(String title, String genre, int releasingYear);
}
