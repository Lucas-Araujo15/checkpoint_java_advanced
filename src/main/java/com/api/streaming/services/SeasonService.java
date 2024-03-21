package com.api.streaming.services;

import com.api.streaming.repositories.MovieRepository;
import com.api.streaming.repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;
}
